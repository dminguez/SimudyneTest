package pojo;

public class ProcessResult {

    private Integer breed_CLost = 0;
    private Integer breed_CGained = 0;
    private Integer breed_CRegained = 0;

    private Integer totalBreedC = 0;
    private Integer totalBreedNC = 0;

    public void addBreedCLost() {
        breed_CLost++;
    }

    public void addBreedCGained() {
        breed_CGained++;
    }

    public void addBreedCRegained() {
        breed_CRegained++;
    }

    public void addTotalBreedC() {
        totalBreedC++;
    }

    public void addTotalBreedNC() {
        totalBreedNC++;
    }

    public Integer getBreed_CLost() {
        return breed_CLost;
    }

    public Integer getBreed_CGained() {
        return breed_CGained;
    }

    public Integer getBreed_CRegained() {
        return breed_CRegained;
    }

    public Integer getTotalBreedC() {
        return totalBreedC;
    }

    public Integer getTotalBreedNC() {
        return totalBreedNC;
    }

    public String toString() {
        StringBuilder resultToOutput = new StringBuilder();
        resultToOutput.append("---------------------------------");
        resultToOutput.append("\nTotal agents in BREED_C: " + getTotalBreedC());
        resultToOutput.append("\nTotal agents in BREED_NC: " + getTotalBreedNC());
        resultToOutput.append("\nTotal BREED_C Lost: " + getBreed_CLost());
        resultToOutput.append("\nTotal BREED_C Gained: " + getBreed_CGained());
        resultToOutput.append("\nTotal BREED_C Regained: " + getBreed_CRegained());
        resultToOutput.append("\n---------------------------------");

        return resultToOutput.toString();
    }

}