package academy.pocu.comp2500.lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import academy.pocu.comp2500.lab11.pocu.*;

public class App {

    private User user;

    public App(User user) {
        this.user = user;
    }

    public void run(BufferedReader in, PrintStream out, PrintStream err) throws IOException, IllegalAccessException, OverflowException {

        boolean endFlag = false;
        while(true) {
            StringBuilder builder = new StringBuilder();
            builder.append("WAREHOUSE: Choose your warehouse!\n")
                    .append("1. APPLE\n")
                    .append("2. MICROSOFT\n")
                    .append("3. SAMSUNG");
            out.print(builder.toString());

            in =  new BufferedReader(new InputStreamReader(System.in));
            String selectMenu = in.readLine();

            //APPLE
            if(selectMenu.equals("1")) {
                //사용자 지갑을 구해옴
                SafeWallet wallet = new SafeWallet(user);
                //지갑 잔고 출력
                while(true) {
                    out.printf("BALANCE: <%d>\n", wallet.getAmount());
                    builder = new StringBuilder();
                    builder.append("PRODUCT_LIST: Choose the product you want to buy!\n")
                            .append("1. IPad              10\n")
                            .append("2. IPod               2\n")
                            .append("3. Macbook Pro       15\n");
                    out.print(builder.toString());
                    String selectProduct = in.readLine();

                    if(selectProduct.equals("1")) {

                    }
                    else if(selectProduct.equals("2")) {

                    }
                    else if(selectProduct.equals("3")) {

                    }
                    else if(selectProduct.equals("exit")) {
                        endFlag = true;
                        return;
                    }
                    else {
                        continue;
                    }
                }

            }

            //MICROSOFT
            else if(selectMenu.equals("2")) {

            }

            //SAMSUNG
            else if(selectMenu.equals("3")) {

            }

            //EXIT
            else if(selectMenu.equals("exit")) {
                return;
            }

            else {
                continue;
            }

        }

    }
}
