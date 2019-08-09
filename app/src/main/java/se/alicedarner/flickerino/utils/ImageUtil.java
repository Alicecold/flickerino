package se.alicedarner.flickerino.utils;

import se.alicedarner.flickerino.service.searchObjects.Photo;

public class ImageUtil {
    public static String getThumbnailUrl(Photo photo){
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_q.jpg", photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
    }

    public static String getHeroImageUrl(String farm, String server, String id, String secret) {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_b.jpg", farm, server, id, secret);
    }
}
