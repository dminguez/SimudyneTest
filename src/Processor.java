import pojo.Policy;
import pojo.ProcessResult;

import java.util.Map;

public class Processor {

    private static Integer yearsToProcess;
    private static Double brandFactor;

    public Processor(Integer yearsToProcess, Double brandFactor) {
        this.yearsToProcess = yearsToProcess;
        this.brandFactor = brandFactor;
    }

    public ProcessResult processData(Map<Long, Policy> policies) {
        ProcessResult result = new ProcessResult();

        if(policies == null || policies.values() == null || policies.values().isEmpty()) {
            return result;
        }

        for(Policy policy : policies.values()) {
            Boolean breedLost = false;
            Boolean breedGained = false;

            /*
             * 1. Calculate the affinity value
             */

            Double affinity = getAffinity(policy);

            for(int year = 0; year < yearsToProcess; year++) {
                /*
                 * 2. Increment the age
                 */

                policy.setAge(policy.getAge() + 1);

                if(!policy.getAutoRenew()) {

                    /*
                     * 3. Check if the breed needs to be changed (and changed back)
                     */

                    if(policy.getBreed().equals(Policy.BREED_C)) {
                        Boolean breedLostCurrentYear = switchToBreedNC(policy, affinity);
                        if(breedLostCurrentYear && !breedLost) {
                            breedLost = true;
                        }
                    }

                    if(policy.getBreed().equals(Policy.BREED_NC)) {
                        Boolean breedGainedCurrentYear = switchToBreedC(policy, affinity);
                        if(breedGainedCurrentYear && !breedGained) {
                            breedGained = true;
                        }
                    }
                }
            }

            /*
             * 4. Make the result aware of the changes that may have happened
             */

            if(breedLost && breedGained) {
                result.addBreedCRegained();
            }
            else if(breedLost) {
                result.addBreedCLost();

            }
            else if(breedGained) {
                result.addBreedCGained();
            }

            /*
             * 5. Add to the result the final breed
             */

            if(policy.getBreed().equals(Policy.BREED_C)) {
                result.addTotalBreedC();
            }
            else {
                result.addTotalBreedNC();
            }

            /*
             * 6. Update the policy instance
             */

            policies.put(policy.getId(), policy);
        }

        return result;
    }

    private Double getAffinity(Policy policy) {
        return policy.getPaymentAtPurchase() / policy.getPrice()
                + (2 * policy.getPromotions() * policy.getInertiaForSwitch());
    }

    private Boolean switchToBreedNC(Policy policy, Double affinity) {
        if(affinity < policy.getSocialGrade() * policy.getBrand()) {
            policy.setBreed(Policy.BREED_NC);
            return true;
        }

        return false;
    }

    private Boolean switchToBreedC(Policy policy, Double affinity) {
        if(affinity < policy.getSocialGrade() * policy.getBrand() * brandFactor) {
            policy.setBreed(Policy.BREED_C);
            return true;
        }

        return false;
    }
}
