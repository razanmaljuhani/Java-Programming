// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//ExamVenue Class
package bar1806065p3_kaumanagementsystem;

public class ExamVenue {

    private int examvenueNo;
    private String floor;
    private int buildingNo;

    public ExamVenue(int examvenueNo, String floor, int buildingNo) {
        this.examvenueNo = examvenueNo;
        this.floor = floor;
        this.buildingNo = buildingNo;
    }

    public int getRoomNo() {
        return examvenueNo;
    }

    public void setRoomNo(int examvenueNo) {
        this.examvenueNo = examvenueNo;

    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Override
    public String toString() {
        return "Exam Venue No.: " + examvenueNo + ", Floor : " + floor + ", Building No.: "
                + buildingNo;
    }
}
