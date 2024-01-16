import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class MyNinja {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = "\n\n2\'0$\n.0* \" \n+5\' \" \n*8$ \" \n(;\" \" \n\'="
                + "  \" \n\'>\" \n&>\" \n&=\" \n<&\" \n)\"%\"\'$\"!\n=#"
                + "\"\"\n<#\"\"\n\'7\"#\n\'6\"#\n)3\"#\n*1\"#\n,+%!\n/\'"
                + "\'\"\n.(\'$\n,+%%\n+\'%(\n-$&\'\n/\"&(\n-%$+\n-6\n,8\n"
                + ",*!+\n,)#*\n,(%)\n,\'\'(\n)*$+\n(+#,\n)*$+\n\n";
        int l = code.length();
        char ch;
        for (int i = 0, j = 0; i < l; i++, j++) {
            ch = code.charAt(i);
            if (ch == '\n') {
                w.write("\n");
                if (j % 2 == 0)
                    j--;
            } else if (j % 2 == 0) {
                for (int k = 0; k < (int) ch - 31; k++)
                    w.write(" ");
            } else {
                for (int k = 0; k < (int) ch - 31; k++)
                    w.write("#");
            }
        }
        w.flush();
    }
}