```json
1.各环节参与方分别在链上生成自己的身份
{ "account":” 制造商A”,
 “did”:”XXXXXXX”,
 “punlickey”:”XXXXXXX”,
 “encodeMethod”:”XXXXXX”,
 “cert”:”XXXXXXX”
}


2.参与方铸造主链追溯凭证
{
"tokenId": " XXXXXXX",
"description":"这是一条整车追溯示例",
“owner”:” 制造商A,供应商A，运输商A，销售商A”,
"supply":[{"供应环节编号": "66080XXXXX",
“主体”：“供应商A”，
“子链”：“供应子链A” }，
{"供应环节编号": "66081XXXXX",
“主体”：“供应商A”，
“子链”：“供应子链A” }],
“manufacture”:{ "制造环节编号": "L6T7752Z7NE0XXXXX",
“主体”： "制造商A"，
“子链”：“ 制造商子链A”},
“transfer”:{ "运输环节编号": " SF10394504XXXXX ",
“主体”： "运输商A"，
“子链”：“ 运输商子链A”}，
“sale”:{ "销售环节编号": " SF10394504XXXXX ",
“主体”： "销售商A"，
“子链”：“ 销售商子链A”}，
}

3参与方铸造子链追溯凭证
{
"tokenId": " XXXXXXX",    
“time”:”2022-6-14 11:15:24”,
"index": "L6T7752Z7NE0XXXXX",
"description":"这是一条整车追溯示例",  
"attributes":{"关重件": [{
            "汽油机总成": "551169XXXX",
            "自动变速箱总成": "889065XXXX",
            "前悬架螺旋弹簧": "889176XXXX",
            "左前减振器总成": "889132XXXX",
        }],
"批次件": [{
            "前轮毂轴承密封圈": "888800XXXX",
            "前轮毂轴承密封圈": "888800XXXX",
            "外六花紧固螺钉M8×15": "888801XXXX"
        }]   
},
"URL": "http://www.subjectdatetrace.com:8080/file/testdata2.jpg",
"digest":"XXXXXX" ,
"owener":"制造商A",
"superviser":"市场监督局",
"superviseRule":"数字签名验签通过",
"traceRule":"上下游可读", 
}





```

