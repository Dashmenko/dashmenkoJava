package by.vsu.mf.ai.ssd.painting;

class pain{
    public static void main (String args[]){

        double df = Double.parseDouble(args[0]);
        int points = 0;

        for (double f = 0; f <= 2*Math.PI; f+= df)
        {
            points++;
            if(df == 0) break;
        }

        double[][][] arr = new double[points][2][2];

        int i = 0;
        for (double f = 0; f <= 2*Math.PI; f += df)
        {

            arr[i][0][0] = Math.sin(f) * 0.5 * (1-(2/3)*Math.pow(Math.sin(2*Math.cos(f/2)),2));
            arr[i][0][1] = Math.cos(f) * 0.5 * (1-(2/3)*Math.pow(Math.sin(2*Math.cos(f/2)),2));
            arr[i][1][0] = Math.tan(f) * 0.5 * (1-(2/3)*Math.pow(Math.sin(2*Math.cos(f/2)),2));
            arr[i][1][1] = 1/(Math.tan(f)) * 0.5 * (1-(2/3)*Math.pow(Math.sin(2*Math.cos(f/2)),2));


            i++;
            if(df == 0) break;
        }

        short arr2[][] = new short[points][3];

        for(int ind = 0; ind < points; ind++)
        {
            arr2[ind][0] = (short)(Math.abs(0 + ind * 1)%255);
            arr2[ind][1] = (short)(Math.abs(0 + ind * 4)%255);
            arr2[ind][2] = (short)(Math.abs(0 + ind * 9)%255);
        }

        Painter p = new Painter();
        p.paint(700, 700, arr, arr2);
    }
}
