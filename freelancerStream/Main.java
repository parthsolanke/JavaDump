import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    // 1.
    public static final int MAX_RATING = 100;

    public static void main(String[] args) {
        List<Freelancer> freelancers = DataProvider.getSampleFreelancers();

        // 1.
        Collections.sort(freelancers);
        System.out.println(freelancers.toString());

        List<Freelancer> sortedFreelancers = freelancers.stream()
            .sorted(Comparator.comparing(Freelancer::getCategory)
            .thenComparing(Comparator.comparingInt(Freelancer::getId)))
            .collect(Collectors.toList());

        System.out.println(sortedFreelancers);

        // 2.
        List<Freelancer> top3Freelancers = freelancers.stream()
        .sorted(Comparator.comparingDouble(Freelancer::getAvgProjectRating).reversed())
        .limit(3)
        .collect(Collectors.toList());
        System.out.println("Top 3 freelancers: " + top3Freelancers);

        Set<String> allClients = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .map(p -> p.getClient())
        .sorted()
        .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("All unique clients: " + allClients);

        Map<String, Double> catToAvgRating = freelancers.stream()
        .collect(Collectors.groupingBy(Freelancer::getCategory,
        Collectors.averagingDouble(Freelancer::getAvgProjectRating)));

        System.out.println("category → average rating" + catToAvgRating);


        int maxBudget = freelancers.stream()
        .flatMap(p -> p.getProjects().stream())
        .mapToInt(Project::getBudget)
        .max()
        .orElse(1);

        List<Double> normBudgets = freelancers.stream()
        .flatMap(p -> p.getProjects().stream())
        .map(p -> p.getBudget() * 100.0 / maxBudget)
        .collect(Collectors.toList());
        System.out.println("Normalized budgets: " + normBudgets);

        Map<String, List<String>> catToFreelancers = freelancers.stream()
        .collect(Collectors.groupingBy(
            Freelancer::getCategory,
            Collectors.mapping(Freelancer::getName, Collectors.toList())
        ));
        System.out.println("category → list of freelancers: " + catToFreelancers);

        // 3.
        List<String> freelancersMoreThan2Proj = freelancers.stream()
        .filter(f -> f.getProjects().size() > 2)
        .map(Freelancer::getName)
        .collect(Collectors.toList());
        System.out.println("Freelancers more than 2 projects: " + freelancersMoreThan2Proj);

        List<String> perfectRatedProjectIds = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .filter(p -> p.getRating() == 100)
        .map(Project::getProjectId)
        .collect(Collectors.toList());
        System.out.println("Perfect Rated projects: " + perfectRatedProjectIds);

        List<String> freelancersWithAbove50Rating = freelancers.stream()
        .filter(f -> f.getProjects().stream().anyMatch(p -> p.getRating() >= 50))
        .map(Freelancer::getName)
        .collect(Collectors.toList());
        System.out.println("Freelancers with above 50 rating: " + freelancersWithAbove50Rating);

        List<String> clientsWithMostProjects = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .collect(Collectors.groupingBy(
            Project::getClient,
            Collectors.counting()
        ))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
        .map(entry -> entry.getKey())
        .collect(Collectors.toList());
        System.out.println("Clients with Most projects: " + clientsWithMostProjects);

        Map<String, Long> ratingDist = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .collect(Collectors.groupingBy(
            project -> {
                int rating = project.getRating();
                if (rating < 50) return "0-49";
                else if (rating < 70) return "50-69";
                else if (rating < 90) return "70-89";
                else return "90-100";
            },
            Collectors.counting()
        ));
        System.out.println("Rating Distrubution: " + ratingDist);

        Map<String, List<String>> ratingDistCompanyList = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .collect(Collectors.groupingBy(
            project -> {
                int rating = project.getRating();
                if (rating < 50) return "0-49";
                else if (rating < 70) return "50-69";
                else if (rating < 90) return "70-89";
                else return "90-100";
            },
            Collectors.mapping(Project::getClient, Collectors.toList())
        ));
        System.out.println("Rating dist to company: " + ratingDistCompanyList);

        IntSummaryStatistics stats = freelancers.stream()
        .flatMap(f -> f.getProjects().stream())
        .mapToInt(Project::getDurationInDays)
        .summaryStatistics();
        System.out.println("Project Duration Stats:");
        System.out.println("Total projects: " + stats.getCount());
        System.out.println("Min duration: " + stats.getMin());
        System.out.println("Max duration: " + stats.getMax());
        System.out.println("Average duration: " + stats.getAverage());

    }
}
