class yearToTest {
    private int year;
    
    public void setYear(int y){
        year = y;
    }

void testYear() {
    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        System.out.println("This year is a leap year");
    } else {
        System.out.println("This year is not a leap year");
    }
}
}

class LeapYearTest{
    
    public static void main(String[]args) {

        yearToTest firstYear = new yearToTest();
        firstYear.setYear(2016);
        firstYear.testYear();
    }        
}