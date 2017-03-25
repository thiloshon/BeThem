/**
 * Created by Thiloshon on 26-Nov-16.
 */
public class Carrier {

    public static void main(String[] args) {


        // The answer is 5

        // lets assume the entire circumference of the earth is divided into 8 equal lengths and its equal to one fuelLength distance.
        // so one jet has capacity of 4 fuelLengths.

        // Now, say three jets takeoff from the carrier at the same time.
        // they all travel 1 fuel length, so all three jets have 3 fuelLength left.
        // now one jet gives 1 fuelLength each to other 2 jets.
        // now two jets have 4 fuelLength and one have (3 - 2 = ) 1 fuelLength left.
        // the jet with 1 fuelLength returns back to carrier which is 1 fuelLength distance away.

        // now the other two jets travel another fuelLength and reach 2nd fuelLength distance.
        // both jets have 3 fuelLength left
        // one jet gives 1 fuelLength to the other jet and travel back 2 fuelLength distances with (3 - 1 = ) 2 fuelLengths
        // now one jet still running has 4 fuelLength left and 6 fuelLength distance left to complete a round.
        // it continues flight and reaches 6th fuelLength with no fuel left and on verge of crashing.

        // when the longest running jet is on the 4th fuelLength, 4th jet take off from carrier facing the oncoming jet.
        // when it reaches 6th fuelLength, after travelling 2 fuelLengths and with 2 fuelLengths left, it meets the
        // first jet on the verge of crashing and gives 1 fuelLength to the first jet.
        // Now both jet have 1 fuelLength with 2 fuelLength distances left to travel.
        // both travel 1 fuelLength distance and reach 7th fuelLength.

        // when the 4th jet is in 6th fuelLength, the 5th jet takes off facing the oncoming jet and reaches 7th fuelLength
        // with 3 fuelLengths left where it meets other 2 jets.
        // it transfers one fuelLengths to other two jets and now all three jets have one fuelLengths and
        // 1 fuelLength distance left which is sufficient to reach carrier safely.

        // PS: if we are able to use a jet twice, we will need only 3 jets since there is enough time for the both jets to
        // reach carrier, refuel and takeoff again.


    }





}
