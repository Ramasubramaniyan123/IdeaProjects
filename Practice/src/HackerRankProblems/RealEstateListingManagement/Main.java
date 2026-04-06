package HackerRankProblems.RealEstateListingManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        IRealEstateApp app = new RealEstateApp();
        int lCount = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= lCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IRealEstateListing e = new RealEstateListing();
            e.setID(Integer.parseInt(a[0]));
            e.setTitle(a[1]);
            e.setDescription(a[2]);
            e.setPrice(Integer.parseInt(a[3]));
            e.setLocation(a[4]);
            app.addListing(e);
        }

        out.println("All Listings:");
        List<IRealEstateListing> allListings = app.getListings();
        for (IRealEstateListing listing : allListings) {
            out.println("ID: " + listing.getID() + ", Title: " + listing.getTitle() + ", Price: " + listing.getPrice() + " , Location: " + listing.getLocation());
        }

        String[] b = br.readLine().trim().split(" ");
        String location = b[0];
        out.println("Listings in " + location + ":");
        List<IRealEstateListing> listingsByLocation = app.getListingsByLocation(location);
        for (IRealEstateListing listing : listingsByLocation) {
            out.println("ID: " + listing.getID() + ", Title: " + listing.getTitle() + ", Price: " + listing.getPrice());
        }

        String[] c = br.readLine().trim().split(" ");
        int minPrice = Integer.parseInt(c[0]);
        int maxPrice = Integer.parseInt(c[1]);
        List<IRealEstateListing> getListingsByPriceRange = app.getListingsByPriceRange(minPrice, maxPrice);
        out.println("Listings By Price Range (" + minPrice + " - " + maxPrice + "):");
        for (IRealEstateListing item : getListingsByPriceRange) {
            out.println("ID: " + item.getID() + ", Title: " + item.getTitle() + ", Price: " + item.getPrice());
        }

        out.flush();
        out.close();
    }
}
