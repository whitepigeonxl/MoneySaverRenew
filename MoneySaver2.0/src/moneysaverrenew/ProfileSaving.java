
package moneysaverrenew;

public class ProfileSaving {
    private int iddataprofile;
    private String name;
    private String lname;
    private float income;
    private float outcome;
    private String date;
    private double saving;
    
    public ProfileSaving(int iddataprofile, String name, String lname, float income, float outcome,String date, double saving ){
       this.iddataprofile = iddataprofile;
       this.name = name;
       this.lname =lname;
       this.income = income;
       this.outcome = outcome;
       this.date = date;
       this.saving = saving;
        
    }

  
    public int getIddataprofile() {
        return iddataprofile;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public float getIncome() {
        return income;
    }

    public float getOutcome() {
        return outcome;
    }

    public String getDate() {
        return date;
    }

    public double getSaving() {
        return saving;
    }
}
    
 
    
   