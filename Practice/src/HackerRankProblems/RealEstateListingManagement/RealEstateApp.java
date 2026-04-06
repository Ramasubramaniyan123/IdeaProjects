package HackerRankProblems.RealEstateListingManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RealEstateApp implements IRealEstateApp{
    private List<IRealEstateListing> listings = new ArrayList<>();
    public void addListing(IRealEstateListing listing) {
        listings.add(listing);
    }

    public void removeListing(int listingID) {
        Iterator<IRealEstateListing> iterator = listings.iterator();
        while (iterator.hasNext()) {
            IRealEstateListing listing = iterator.next();
            if(listing.getID() == listingID) {
                iterator.remove();
                break;
            }
        }
    }

    public void updateListing(IRealEstateListing listing) {
        ListIterator<IRealEstateListing> iterator = listings.listIterator();
        while (iterator.hasNext()) {
            IRealEstateListing listing1 = iterator.next();
            if(listing1.getID() == listing.getID()) {
                iterator.set(listing);
                return;
            }
        }
    }

    public List<IRealEstateListing> getListings() {
        return listings;
    }

    public List<IRealEstateListing> getListingsByLocation(String location) {
        List<IRealEstateListing> list=new  ArrayList<>();
        Iterator<IRealEstateListing> iterator=listings.iterator();
        while (iterator.hasNext()) {
            IRealEstateListing listing=iterator.next();
            if(listing.getLocation().equals(location)) {
                list.add(listing);
            }
        }
        return list;
    }

    public List<IRealEstateListing> getListingsByPriceRange(int minPrice, int maxPrice) {
        List<IRealEstateListing> list=new  ArrayList<>();
        Iterator<IRealEstateListing> iterator=listings.iterator();
        while(iterator.hasNext()) {
            IRealEstateListing listing=iterator.next();
            int money =  listing.getPrice();
            if( money <= minPrice && money<=maxPrice) {
                list.add(listing);
            }
        }
        return list;
    }
}
