
version: [Apache Lucene 7.2.1](https://lucene.apache.org/)


## Index

###索引儲存位址宣告

	String index_location;					// index location
	
	File f = new File(index_location);
	Analyzer analyzer = new IKAnalyzer(true);
	Directory dir = FSDirectory.open(f.toPath());
	IndexReader reader = new IndexWriter(dir, new IndexWriterConfig(analyzer));


###索引宣告

	IndexWriter indexWriter;
	Document doc = new Document();

###建立索引

###### 文字
	String text_field = "TextFied";
	String input_str = {Text};
	doc.add(new TextField(text_field, input_str, Field.Store.YES));

<https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/document/TextField.html>

###### 數值
	
	String viewCount_field = "ViewCount";
	int viewcount = {numerical};
	doc.add(new StoredField(viewCount_field, viewcount));
	doc.add(new SortedNumericDocValuesField(viewCount_field, viewcount));

<https://lucene.apache.org/core/7_2_1/core/index.html?org/apache/lucene/document/StoredField.html>


###建立可進行排序資料	
###### 數值

	String duration_field = "duration";
	double duration_val = 100.0;
	doc.add(new DoublePoint(duration_field, duration_val));

	

### Query

### single query


### multi query


### fuzzy query

###### 文字
	Query fuzzyQuery_title = new FuzzyQuery(new Term(FIELD_TITLE, query_string), 2, 0);
	Query fuzzyQuery_text = new FuzzyQuery(new Term(FIELD_CAPTION, query_string), 2, 0);
	BooleanQuery.Builder query = new BooleanQuery.Builder();
	query.add(fuzzyQuery_title, BooleanClause.Occur.SHOULD);
	query.add(fuzzyQuery_text, BooleanClause.Occur.SHOULD);

<https://lucene.apache.org/core/7_2_0/core/org/apache/lucene/search/FuzzyQuery.html>