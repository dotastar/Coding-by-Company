/*
题目就是flatten json to a list of map, 有一段json，比如说如下：
{. from: 1point3acres.com/bbs 
  "uuid": "abc",
  "properties": {
    "sessionName": "Test session name",
    "waypoints": [. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
      {"uuid": "def", "properties": {"latitude": 3}}
    ]
  }
}


把它转化成List<Map<String, Object>>， map里面uuid是key, properties是value。 所以结果应该像下面.鏈枃鍘熷垱鑷�1point3acres璁哄潧

[

  {"uuid": "abc", "properties": {"sessionName": "Test session name", "waypoints": ["def"]}},

  {"uuid": "def", "properties": {"latitude": 3}},. From 1point 3acres bbs

  ...

]
*/
class Untitled {
	public static void main(String[] args) {
		
	}
}