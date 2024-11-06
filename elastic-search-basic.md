# Table of Contents
- [Elastic Search](#elastic-search)
  - [Elastic Search Architecture](#elastic-search-architecture)
    - [Elastic Search Cluster](#elastic-search-cluster)
    - [Elastic Search Index](#elastic-search-index)
    - [How Read/Write Operations Happens](#how-read/write-operations-happens)
    - [Fault Tolerance](#fault-tolerance)



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
 <img src="/es-cluster.png" width="600"/>
 
- Replica(R) shards do only read operation and only copy data from their primary shard id
- Primary(P) shards do readh/write operations for doc_ids that are hashed to them.
- Nodes are physically independent of each other.

### Elastic Search Index
- if u want more data in index, u have to add more shards.
 <img src="/es-index.png" width="600"/>

### How Read/Write Operations Happens
- **Write** -->Lets say doc id 20 i want to write. so here doc id 20 is hashed to shard 5 of your ES index. Primary shard 5 will write the data from doc id 20. Replicas shard will copy the data from shard 5
- **Read**-->
   - Get request for doc id 20 comes in
   - Hash function says doc id 20 is in shard id 5
   - any shard with id 5(primary or replica) can return the data for document id 20. Note if primary shard with id 5 is busy and replica shard with id 5 can return the data

### Fault Tolerance
- If any node goes down and primary shard was there on that node, a replica shard (with same id) will get promoted to primary so u can continue to write data.
