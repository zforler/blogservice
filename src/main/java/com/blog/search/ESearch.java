package com.blog.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Map;

public class ESearch {
    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));


    public static boolean index(String json){
        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "3");
        String jsonString = "{" +
                "\"user\":\"kim\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"out\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        boolean res = false;
        try {
            IndexResponse indexResponse = client.index(request);
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            if(1 == shardInfo.getSuccessful()){
                res = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String get(){
        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "2");
        String res = "";
        try {
            GetResponse getResponse = client.get(getRequest);
            if (getResponse.isExists()) {
//                long version = getResponse.getVersion();
                res = getResponse.getSourceAsString();
//                Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
//                byte[] sourceAsBytes = getResponse.getSourceAsBytes();
//                System.out.println(sourceAsString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void search(){
//        SearchRequest searchRequest = new SearchRequest();

        SearchRequest searchRequest = new SearchRequest("posts");
        searchRequest.types("doc");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "kimchy");
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("out","message");


        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
//        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse searchResponse = client.search(searchRequest);
            SearchHits hits = searchResponse.getHits();
            for (SearchHit hit : hits) {
                String sourceAsString = hit.getSourceAsString();
                System.out.println(sourceAsString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        ESearch.index("s");
//        ESearch.get();
        ESearch.search();
    }
}
