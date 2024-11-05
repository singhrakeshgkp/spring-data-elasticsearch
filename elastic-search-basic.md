# Table of Contents
- [Elastic Search](#elastic-search)
  - [Elastic Search Architecture](#elastic-search-architecture)
    - [Elastic Search Cluster](#elastic-search-cluster)



# Elastic Search
- Elasticsearch is a search engine and analytics tool that stores and indexes data for fast searching and analysis.

## Elastic Search Architecture
- Inverted indices are heart of elastic search
  - An elastic search index is made up of shard's
  - A Shard is a standalone Lucence instance.
  - These instances are called inverted indices.
  - Inverted indices map tokens(like words) to document that contains those words.
    <table>
      <tr>
        <td>document 1</td>
        <td>Welcome to elasticsearch</td>
        </tr>
      <tr>
        <td>document 2</td>
        <td>Welcome</td>
        </tr>
    </table>

    <table>
      <tr>
        <td colspan="2">Inverted index</td>
        </tr>
      <tr>
        <td>term</td>
        <td>document id with term</td>
      </tr>
      <tr>
        <td>Welcome</td>
        <td>1,2</td>
      </tr>
 
      <tr>
        <td>to</td>
        <td>1</td>
      </tr>
     <tr>
        <td>elasticsearch</td>
        <td>1</td>
      </tr>
    </table>
### Elastic Search Cluster
- Following digram is representation of cluster with two primary shards 0 and 1 and 2 replica shards per primary shards.
  
- Replica(R) shards do only read operation and only copy data from their primary shard........
- Primary(P) shards do readh/write operation..........
  
