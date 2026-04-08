
//my logic for thisis we will take this int array and iterate it suppose first one is 
//5 we will store it then 
//if it pays 5 we keep it
// if it pays 10 we check our storage if we have 5 change we give him 
// if he shows up with 20 we check our storage and check if it has 10 and 5 in it then return 
//it to the customer
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                
                five++;
            } else if (bill == 10) {
                
                if (five == 0) return false;
                five--;
                ten++;
            } else {
               



                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } 
               

                else if (five >= 3) {
                    five -= 3;
                } 
                


                else {
                    return false;
                }
            }
        }

        return true;
    }
}

       
