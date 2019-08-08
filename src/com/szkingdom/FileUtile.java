package com.szkingdom;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class FileUtile {
    /**
     * 文件操作
     */
    public void File() throws IOException {
        // 输出表头
        System.out.println("TA代码 \t产品代码\t\t产品名称  \t\t发行机构\t\t净值");

        // 新建输入文件和输出文件
        File fileIn = new File("D:/bk/fund.txt");
        File fileOut = new File("D:/bk/fund_bk.txt");

        try {
            // 如果文件不存在则创建文件
            if (!fileIn.exists()) {
                fileIn.createNewFile();
            }
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建输入流和输出流
        InputStreamReader rdCto = new InputStreamReader(new FileInputStream(fileIn), "GBK"); //以GBK方式进行读
        OutputStreamWriter outSw = new OutputStreamWriter(new FileOutputStream(fileOut), "UTF-8");// 以UTF-8方式进行输出
        BufferedReader bfReader = new BufferedReader(rdCto);
        BufferedWriter bfWriter = new BufferedWriter(outSw);

        String txtline;  // 读取到的字符串
        while ((txtline = bfReader.readLine()) != null) {
            bfWriter.write(txtline); //将读取到的字符串写入到目标文件中
            bfWriter.write("\r\n");
            // 将“|”用“\t\t”替换掉
            txtline = txtline.replace("|", "\t\t");
            // 控制台输出替换结果
            System.out.println(txtline);
        }

        // 关闭读入流
        bfReader.close();
        // 在输出文件中追加要添加的字符串
        bfWriter.write("JZ|900001|新员工日日赢|金证股份|2.9999");
        // 关闭写入流
        bfWriter.close();
        // 删除原有文件
        fileIn.delete();

    }

}
