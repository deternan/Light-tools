
version: [Apache Lucene 7.2.1](https://lucene.apache.org/)


### Index

####索引儲存位址宣告

	String index_location;					// index location
	
	File f = new File(index_location);
	Analyzer analyzer = new IKAnalyzer(true);
	Directory dir = FSDirectory.open(f.toPath());
	IndexReader reader = new IndexWriter(dir, new IndexWriterConfig(analyzer));


####索引宣告

	IndexWriter indexWriter;
	Document doc = new Document();

####建立索引

###### 文字
	String text_field = "TextFied";
	String input_str = "文字在這裡輸入";
	doc.add(new TextField(text_field, input_str, Field.Store.YES));

<https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/document/TextField.html>

###### 數值
	String numericalField = "NumField";
	int numerical = 123;
	doc.add(new StoredField(numericalField, numerical));

<https://lucene.apache.org/core/7_2_1/core/index.html?org/apache/lucene/document/StoredField.html>


####建立排序資料

