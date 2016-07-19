

public class Parenthesis { 
    public static void main(String [] args){
        int n=3;
        String parenthesis = "";
        _printParenthesis(0, n,0,0,parenthesis);
    }
    
    public static void _printParenthesis(int pos, int n, int open, int close, String parenthesis ){    
    	System.out.println("Inovked with pos : "+pos + " n : "+n+ " open : "+open+" close : "+ close + " par : "+parenthesis);
        if(close == n) 
        {
            print(parenthesis);
            return;
        }
        if(open > close) {
            _printParenthesis(pos+1, n, open, close+1,parenthesis+"}");
        }
        if(open < n) {
            _printParenthesis(pos+1, n, open+1, close,parenthesis+"{");
        }
    }
    
    public static void print(String parenthesis){
        System.out.println(parenthesis); 
    }
}