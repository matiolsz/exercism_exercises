package org.example;

//You are given an array of strings ideas that represents a list of names to be used in the process of naming a company.
//
// The process of naming a company is as follows:
//
//        Choose 2 distinct names from ideas, call them ideaA and ideaB.
//        Swap the first letters of ideaA and ideaB with each other.
//        If both of the new names are not found in the original ideas,
//        then the name ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
//        Otherwise, it is not a valid name.
//        Return the number of distinct valid names for the company.
//

import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyName {

    public ArrayList<String> companyNames = new ArrayList<>();

    public long distinctNames(String[] ideas) {

        for (int i = 0; i < ideas.length; i++) {
            for (int j = 0; j < ideas.length; j++) {
                if (!ideas[i].equals(ideas[j])) {
                    String newPossibleCompanyName = generateCompanyName(ideas, ideas[i], ideas[j]);

                    if (!companyNames.contains(newPossibleCompanyName) && !newPossibleCompanyName.equals("")) {
                        companyNames.add(newPossibleCompanyName);
                    }
                }
            }
        }
        return companyNames.size();
    }

    private String generateCompanyName(String[] ideas, String ideaA, String ideaB) {
        String firstLetterOfIdeaA = ideaA.substring(0, 1);
        String firstLetterOfIdeaB = ideaB.substring(0, 1);
        if (firstLetterOfIdeaB.equals(firstLetterOfIdeaA)) {
            return "";
        }
        String secondPartOfIdeaA = ideaA.substring(1);
        String secondPartOfIdeaB = ideaB.substring(1);

        String exchangedIdeaA = firstLetterOfIdeaB + secondPartOfIdeaA;
        String exchangedIdeaB = firstLetterOfIdeaA + secondPartOfIdeaB;
        List listOfDoubledIdeasA = Arrays.stream(ideas).filter(s -> s.equals(exchangedIdeaA)).collect(Collectors.toList());
        List listOfDoubledIdeasB = Arrays.stream(ideas).filter(s -> s.equals(exchangedIdeaB)).collect(Collectors.toList());
        if (listOfDoubledIdeasA.isEmpty() && listOfDoubledIdeasB.isEmpty()) {
            if (!exchangedIdeaB.equals(exchangedIdeaA)) {
                return exchangedIdeaA + " " + exchangedIdeaB;
            }
        }
        return "";
    }

}
