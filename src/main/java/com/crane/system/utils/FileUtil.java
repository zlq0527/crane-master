package com.crane.system.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * FileUtil
 *
 * @author Tght
 * @date 2022/12/05
 */
@Slf4j
public class FileUtil {


    /**
     * 项目名称
     */
    public static final String PROJECT_NAME = "crane-master";

    public static final String STORAGE_PATH = "\\src\\main\\resources\\files\\";

    public static String basePath;

    static {
        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int i = t.indexOf(PROJECT_NAME);
        basePath = System.getProperty("user.dir") + STORAGE_PATH.replace('\\', '/');
    }



    /**
     * 接口一:上传本地
     *
     * @param file 文件
     * @return {@link String}
     */
    public static String uploadLocal(MultipartFile file) {
        log.info("上传文件名字为" + file.getOriginalFilename());
        //获取文件名称
        String end = file.getOriginalFilename().split("\\.")[1];
        // 定义文件的唯一标识（前缀） uuid
        String uuid = (UUID.randomUUID().toString().replace("-", "").toUpperCase()) + "." + end;
        // 文件的路径
        log.info("文件根路径:" + basePath);
        try {
            writeToFile(file.getBytes(), basePath, uuid);
        } catch (Exception e) {
            throw new GlobalExceptionHandler("文件上传工具异常");
        }
        // 返回结果uuid
        uuid = uuid.split("\\.")[0];
        log.info("数据库需要存储的信息uuid:" + uuid);
        return uuid;
    }


    /**
     * 接口二：下载本地
     *
     * @param uuid     uuid
     * @param response 响应
     * @return {@link Boolean}
     */
    public static void downloadLocal(String uuid, HttpServletResponse response) {
        // 新建一个输出流对象
        OutputStream os;
        // 根路径，找到定义文件


        // 获取到根路径下面所有的文件名称
        List<String> fileNames = getAllFileName(basePath);

        // 根据访问携带的uuid，来对应路径下找文件，再输出出来     不用huTool
        String avatar = fileNames.stream().filter(name -> name.contains(uuid)).findAny().orElse("");
        try {
            // 如果找到了对应文件，就说明文件是可以被下载的
            if (!StringUtils.isEmpty(avatar)) {
                // 加请求头
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(avatar, "UTF-8"));
                response.setContentType("application/octet-stream");
                // 路径加文件名，通过文件路径读取文件字节流
                byte[] bytes = toByteArray(basePath + avatar);
                // 通过输出流返回文件
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            throw new GlobalExceptionHandler("文件下载失败");
        }
    }


    /**
     * 写入文件
     *
     * @param bytes        字节
     * @param rootFilePath 根文件路径
     * @param fileName     文件名称
     */
    public static void writeToFile(byte[] bytes, String rootFilePath, String fileName) {
        byte[] sourceByte = bytes;
        if (null != sourceByte) {
            try {
                //文件路径（路径+文件名）
                File file = new File(rootFilePath + fileName);
                //文件不存在则创建文件，先创建目录
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                //文件输出流将数据写入文件
                FileOutputStream outStream = new FileOutputStream(file);
                outStream.write(sourceByte);
                outStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new GlobalExceptionHandler("文件上传写入异常");
            } finally {
                log.info("文件上传名字:" + fileName + ",路径:" + rootFilePath);
            }
        }
    }

    /**
     * 根据文件路径获取文件字节流
     *
     * @return filePath  文件路径
     * @throws IOException
     */
    public static byte[] toByteArray(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }


    /**
     * <h1>获取指定文件夹下所有文件，不含文件夹</h1>
     *
     * @param dirFilePath 文件夹路径
     * @return
     */
    public static List<File> getAllFile(String dirFilePath) {
        if (StringUtils.isEmpty(dirFilePath)) {
            throw new GlobalExceptionHandler("文件绝对路径为传入或者获取失败");
        }
        return getAllFile(new File(dirFilePath));
    }

    /**
     * 获取路径下的文件名称
     *
     * @param dirFilePath dir文件路径
     * @return {@link List}<{@link String}>
     */
    public static List<String> getAllFileName(String dirFilePath) {
        if (StringUtils.isEmpty(dirFilePath)) {
            throw new GlobalExceptionHandler("文件绝对路径为传入或者获取失败");
        }
        List<File> allFile = getAllFile(new File(dirFilePath));
        return allFile.stream().map(File::getName).collect(Collectors.toList());
    }


    /**
     * <h1>获取指定文件夹下所有文件，不含文件夹</h1>
     *
     * @param dirFile 文件夹
     * @return
     */
    public static List<File> getAllFile(File dirFile) {
        // 如果文件夹不存在或着不是文件夹，则返回 null
        if (Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile())
            return null;

        File[] childrenFiles = dirFile.listFiles();
        if (Objects.isNull(childrenFiles) || childrenFiles.length == 0)
            return null;

        List<File> files = new ArrayList<>();
        for (File childFile : childrenFiles) {

            // 如果时文件，直接添加到结果集合
            if (childFile.isFile()) {
                files.add(childFile);
            } else {
                // 如果是文件夹，则将其内部文件添加进结果集合
                List<File> cFiles = getAllFile(childFile);
                if (Objects.isNull(cFiles) || cFiles.isEmpty()) continue;
                files.addAll(cFiles);
            }

        }
        return files;
    }
}


