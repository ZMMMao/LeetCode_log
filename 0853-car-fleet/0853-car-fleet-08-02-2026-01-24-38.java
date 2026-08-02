/**
fleet happens if catchup
int[n][2] position - int[2] (position, speed)

 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || speed == null) return -1;

        int[][] cars = new int[position.length][2];
        for(int i = 0; i<position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        int fleet = 0;
        double frontTime = 0;

        for(int[] car : cars){
            double time = (double)((target - car[0])) / car[1];
            if(time > frontTime){
                fleet++;
                frontTime = time;
            }
        }
        return fleet;
    }
}