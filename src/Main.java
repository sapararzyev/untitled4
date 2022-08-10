import java.util.Random;

public class Main {
    public static String[] heroeAttacktype = {"physical", "Magical", "kinetic", "Medic"};
    public static int[] heroeHealth = {270, 280, 260, 290};
    public static int[] heroesDamage = {20, 15, 25, 0};

    public static int bossHealth = 700;
    public static int bossDamaga = 50;
    public static String bossDefencetype = "";

    public static int roundNumber = 0;

    public static void main (String[] args){
        prinstatistics();
        while (!isGamefinished()){
               round();
        }
    }

    public static void  round(){
        roundNumber++;
        prinstatistics();
        heroesHits();
        prinstatistics();
        bossHealth();
        prinstatistics();
        isGamefinished();
        prinstatistics();
        heal();
        choosDefenceType();
        prinstatistics();


    }

    public static boolean isGamefinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won");
            return true;

        }
        boolean allheroesDead = true;
        for (int i = 0; i <heroeHealth.length ; i++) {
            if (heroeHealth[i]>0){
                allheroesDead = false;
                break;
            }

        }
        if (allheroesDead){
            System.out.println("boss won");
        }
        return allheroesDead;
    }




    private static void bossHealth() {
        roundNumber++;
        for (int i = 0; i < heroeHealth.length; i++) {
            heroeHealth[i] = heroeHealth[i] - bossDamaga;

        }
    }

    private static void heroesHits() {
        for (int i = 0; i < heroeHealth.length; i++) {
            bossHealth = bossHealth - heroesDamage[i];

        }
    }

    private static void prinstatistics() {
        System.out.println("********" + roundNumber + "***********");
        System.out.println("восс хелс" + bossHealth + "[" + bossDamaga + "]");

        for (int i = 0; i < heroeHealth.length; i++) {
            System.out.println(" hero " + heroeAttacktype[i] + " Health " + heroeHealth[i] + "[" + heroesDamage[i] + "]");


        }
    }
       public static void heal(){
        int low = 0;
           for (int i = 0; i <heroeHealth.length; i++) {
               for (int j = 0; j < heroeHealth.length; j++) {
                   if (heroeHealth[i]>heroeHealth[j]){
                       low =j;
                   }

               }

           }
           System.out.println("******");
           System.out.println(heroeHealth[low]);
           heroeHealth[low]+=100;
           System.out.println(heroeHealth[low]);
           System.out.println("*******");

     }
     public static void choosDefenceType(){
        Random random = new Random();
        int randomindex = random.nextInt(3);
     }






}