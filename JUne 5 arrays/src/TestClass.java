import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TestClass {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		byte[] b_arr = {71, 101, 101, 107, 115};
//		Charset cs = Charset.defaultCharset();
//		String s_byte_char = new String(b_arr, cs);
//		System.out.println(s_byte_char);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        boolean time[] = new boolean[1440];
        boolean ist = true;
        for(int i = 0; i < N && ist;i++){
            String ip = br.readLine();
            
            String[] a = ip.split("-");
            String []a1 = a[0].split(":");
            int s = (Integer.parseInt(a1[0])*60)+Integer.parseInt(a1[1]);
            String a2[] = a[1].split(":");
            int e = Integer.parseInt(a2[0])*60+Integer.parseInt(a2[1]);
            while(s<e && ist){
                if(!time[s]){
                    time[s] = true;
                }else{
                    ist = false;
                }
                s++;
            }
            
        }
        if(ist){
            System.out.println("Who needs a moderator?");
        }else{
            System.out.println("Will need a moderator!");
        }
 
        
 
        
    }
}