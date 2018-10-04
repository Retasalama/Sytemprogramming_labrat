package t.e.lunchmenu;

public class Lunches {

    public Lunches(String aLunchGategory, String aHeadCourse, String aSidedish, String aSecondSideDish) {
        this.lunchGategory = aLunchGategory;
        this.headCourse = aHeadCourse;
        this.sideDish = aSidedish;
        this.secondSideDish = aSecondSideDish;
    }

    public Lunches() {

    }

    private String lunchGategory = "";
    private String headCourse = "";
    private String sideDish = "";
    private String secondSideDish = "";
    private int iconId;

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getSecondSideDish() {
        return secondSideDish;
    }

    public void setSecondSideDish(String secondSideDish) {
        this.sideDish = sideDish + " and " + secondSideDish;
    }

    public String getLunchGategory() {
        return lunchGategory;
    }

    public void setLunchGategory(String lunchGategory) {
        this.lunchGategory = lunchGategory;
    }

    public String getHeadCourse() {
        return headCourse;
    }

    public void setHeadCourse(String headCourse) {
        this.headCourse = headCourse;
    }

    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }
}
