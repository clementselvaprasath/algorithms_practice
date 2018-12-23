package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Design a simplified version of Twitter where users can post tweets, 
 * follow/unfollow another user and is able to see the 10 most recent
 *  tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the 
user's news feed. 
Each item in the news feed must be posted by users who the user 
followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
 * @author qz
 *
 */
public class DesignTwitter {

	// friends map
    Map<Integer, Set<Integer>> friends;
    // tweets
    Map<Integer, Tweet> tweets;
    
    int time;
    /** Initialize your data structure here. */
    public DesignTwitter() {
        friends = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(userId, tweetId, time++);
        if (tweets.containsKey(userId)) {
            t.next = tweets.get(userId);
        }
        tweets.put(userId, t);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }
        if (friends.containsKey(userId)) {
            Set<Integer> friendSet = friends.get(userId);
            for (Integer id : friendSet) {
                if (tweets.containsKey(id)) {
                    pq.offer(tweets.get(id));
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty()) break;
            Tweet t = pq.poll();
            list.add(t.tweetId);
            if (t.next != null) {
                pq.offer(t.next);
            }
        }
        
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!friends.containsKey(followerId)) {
            friends.put(followerId, new HashSet<>());
        }
        friends.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (friends.containsKey(followerId)) {
            friends.get(followerId).remove(followeeId);
        }
    }
    
    private class Tweet {
        int id;
        int tweetId;
        int time;
        Tweet next;
        public Tweet(int id, int tweetId, int time) {
            this.id = id;
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    
    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
