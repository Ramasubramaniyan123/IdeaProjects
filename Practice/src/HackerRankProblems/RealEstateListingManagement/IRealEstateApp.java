package HackerRankProblems.RealEstateListingManagement;

import java.util.List;

public interface IRealEstateApp {

    void addListing(IRealEstateListing listing);

    void removeListing(int listingID);

    void updateListing(IRealEstateListing listing);

    List<IRealEstateListing> getListings();

    List<IRealEstateListing> getListingsByLocation(String location);

    List<IRealEstateListing> getListingsByPriceRange(int minPrice, int maxPrice);
}

