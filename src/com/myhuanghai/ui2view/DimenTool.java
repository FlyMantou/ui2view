package com.myhuanghai.ui2view;

import com.intellij.openapi.project.Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DimenTool {


    public static float defaultDp = 360f;
    public static float uippi = 72f;
    public static float uiwidth = 1080f;

    private static boolean b1 = true;
    private static boolean b2 = true;
    private static boolean b3 = true;
    private static boolean b4 = true;
    private static boolean b5 = true;
    private static boolean b6 = true;
    private static boolean b7 = true;
    private static boolean b8 = true;
    private static boolean b9 = true;
    private static boolean b10 = true;
    private static boolean b11 = true;
    private static boolean b12 = true;
    private static boolean b13 = true;
    private static boolean b14 = true;
    private static boolean b15 = true;
    private static boolean b16 = true;
    private static boolean b17 = true;

    private static final String[] defaultDPArr = new String[]{"384", "392", "400", "410",
            "411", "450", "480", "533",
            "540", "592", "600", "640",
            "662", "720", "768", "800",
            "811", "820", "960", "961",
            "1024", "1280", "1365"};

    public static int getPx(int px) {
        // float f = uippi/160f;//1dp = f px
        // int dp = (int)((float)px/f);//目标像素在ui设备屏幕有多少dp
        float dp = (float) px / uiwidth * defaultDp;
        //int dp = (int)((float)px/uippi*160f) ;
        return (int) dp;
    }

    public static void Davn(Project project, int px) {

        File file = new File("./resources/1.txt");
        BufferedReader bis = null;
        String s = null;
        try {
            bis = new BufferedReader(new FileReader(file));
            int index = 0;
            while (null != (s = bis.readLine())) {
                if (index == 0)
                    defaultDp = Integer.parseInt(s);
                else if (index == 1) {
                    uippi = Integer.parseInt(s);
                } else if (index == 2) {
                    uiwidth = Integer.parseInt(s);
                } else if (index == 3) {
                    if (Integer.parseInt(s) == 1) {
                        b1 = true;
                    } else {
                        b1 = false;
                    }
                } else if (index == 4) {
                    if (Integer.parseInt(s) == 1) {
                        b2 = true;
                    } else {
                        b2 = false;
                    }
                } else if (index == 5) {
                    if (Integer.parseInt(s) == 1) {
                        b3 = true;
                    } else {
                        b3 = false;
                    }
                } else if (index == 6) {
                    if (Integer.parseInt(s) == 1) {
                        b4 = true;
                    } else {
                        b4 = false;
                    }
                } else if (index == 7) {
                    if (Integer.parseInt(s) == 1) {
                        b5 = true;
                    } else {
                        b5 = false;
                    }
                } else if (index == 8) {
                    if (Integer.parseInt(s) == 1) {
                        b6 = true;
                    } else {
                        b6 = false;
                    }
                } else if (index == 9) {
                    if (Integer.parseInt(s) == 1) {
                        b7 = true;
                    } else {
                        b7 = false;
                    }
                } else if (index == 10) {
                    if (Integer.parseInt(s) == 1) {
                        b8 = true;
                    } else {
                        b8 = false;
                    }
                } else if (index == 11) {
                    if (Integer.parseInt(s) == 1) {
                        b9 = true;
                    } else {
                        b9 = false;
                    }
                } else if (index == 12) {
                    if (Integer.parseInt(s) == 1) {
                        b10 = true;
                    } else {
                        b10 = false;
                    }
                } else if (index == 13) {
                    if (Integer.parseInt(s) == 1) {
                        b11 = true;
                    } else {
                        b11 = false;
                    }
                } else if (index == 14) {
                    if (Integer.parseInt(s) == 1) {
                        b12 = true;
                    } else {
                        b12 = false;
                    }
                } else if (index == 15) {
                    if (Integer.parseInt(s) == 1) {
                        b13 = true;
                    } else {
                        b13 = false;
                    }
                } else if (index == 16) {
                    if (Integer.parseInt(s) == 1) {
                        b14 = true;
                    } else {
                        b14 = false;
                    }
                } else if (index == 17) {
                    if (Integer.parseInt(s) == 1) {
                        b15 = true;
                    } else {
                        b15 = false;
                    }
                } else if (index == 18) {
                    if (Integer.parseInt(s) == 1) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                } else if (index == 19) {
                    if (Integer.parseInt(s) == 1) {
                        b17 = true;
                    } else {
                        b17 = false;
                    }
                }
                index++;
            }
            s = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bis = null;
        }
        String path = project.getBasePath() + "/";

        /*StringBuilder defsb = new StringBuilder();

        File def = new File(path + "app/src/main/res/values/dimens.xml");

        Make(def);
        defsb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
                    "<resources>\r\n" + "</resources>");


        defsb.append("\t").append("<dimen name=\"x" + px + "\">" + (getPx(px) *  / defaultDp) + "dp</dimen>").append("\r\n").append("</resources>");
        writeFile(def, defsb.toString());*/

        for (int x=0;x<defaultDPArr.length;x++){
            StringBuilder stringBuilder = new StringBuilder();

            File file1 = new File(path + "app/src/main/res/values-w"+defaultDPArr[x]+"dp/dimens.xml");
            if (!file1.exists()) {
                Make(file1);
                stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
                        "<resources>\r\n" + "</resources>");

            }
            stringBuilder.append("\t").append("<dimen name=\"x" + px + "\">" + (getPx(px) * Integer.parseInt(defaultDPArr[x]) / defaultDp) + "dp</dimen>").append("\r\n").append("</resources>");
            writeFile(file1, stringBuilder.toString());
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    private static void rep(String ch, File file) {
        BufferedReader bis = null;
        FileWriter bos = null;
        String s = null;
        File file1 = new File(file.getPath() + "1");
        try {
            bis = new BufferedReader(new FileReader(file));

            bos = new FileWriter(file1);
            while (null != (s = bis.readLine())) {


                s = s.replaceAll(ch, "");
                if (s.equals(""))
                    continue;
                s = s + "\r\n";
                System.out.println(s);
                bos.write(s);
            }
            bos.close();
            bis.close();
            s = null;
            bis = null;
            bos = null;
            BufferedReader bis1 = null;
            FileWriter bos1 = null;
            bis1 = new BufferedReader(new FileReader(file1));
            bos1 = new FileWriter(file);
            while (null != (s = bis1.readLine())) {
                s = s + "\r\n";
                bos1.write(s);
            }

            bos1.close();
            bis1.close();
            s = null;
            file1.delete();
            bis1 = null;
            bos1 = null;

        } catch (FileNotFoundException e) {
            System.out.println("未找到文件\n");
        } catch (IOException ee) {
            System.out.println("aaa");
        }


    }

    /**
     * 写入方法
     */

    public static void writeFile(File file, String text) {

        PrintWriter out = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(file, true);
            out = new PrintWriter(fw);
            out.println(text);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            out.close();
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fw = null;
            out = null;
        }


        rep("</resources>", file);

        try {
            fw = new FileWriter(file, true);
            out = new PrintWriter(fw);
            out.println("</resources>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out = null;
            fw = null;
        }


    }

    //自定义检测生成指定文件夹下的指定文件
    public static void Make(File file) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
