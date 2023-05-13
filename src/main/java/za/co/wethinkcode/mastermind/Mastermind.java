package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){
        //TODO: implement the main run loop logic
        String startUpMessage = "4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.";
//        System.out.println(code);
        System.out.println(startUpMessage);
//        String code = "6178";
        System.out.println(code);
        int turns = 12;
        String userCode ;
        int notInCorrectPlace = 0;
        int inCorrectPlace = 0;
        do {
            turns --;
            userCode = player.getGuess();
            for (int i = 0; i < 4; i ++) {
                if (code.charAt(i) == userCode.charAt(i)) {
                    inCorrectPlace++;
                }
            }
            for (int i = 0; i < 4; i ++){
                for (int j = 0; j < 4 ; j ++) {
                    if (code.charAt(i) == userCode.charAt(j) && code.charAt(i) != userCode.charAt(i)){
                        notInCorrectPlace ++ ;
                    }
                }
            }
            System.out.println("Number of correct digits in correct place: " + inCorrectPlace);
            System.out.println("Number of correct digits not in correct place: " + notInCorrectPlace);
            if(inCorrectPlace == 4){
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: "+ code);
                break;
            }else if (turns !=0){
                System.out.println("Turns left: "+ turns);
                inCorrectPlace = 0;
                notInCorrectPlace = 0;
            }else{
                System.out.println("No more turns left.");
                System.out.println("The code was: "+ code);
            }
        }while (turns != 0);
    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
