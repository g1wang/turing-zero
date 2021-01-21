## Mybatis集成2-CRUD

### Insert

#### Insert

- BookMapper.java
```
    @Insert("insert into book(book_name,category,path) value (#{bookName},#{category},#{path})")
    int insert(@Param("bookName") String bookName, @Param("category") String category, @Param("path") String path);
```

#### InsertProvider
- BookMapper.java
```
    @InsertProvider(type = BookProvider.class, method = "insertAllBooks")
    int intsertAll(@Param("list") List<Book> list);
```
- BookProvider.java
```
    /**
     * 批量插入
     * @param map
     * @return
     */
    public String insertAllBooks(Map map) {
        List<Book> bookList = (List<Book>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into book ");
        sb.append("(book_name,category,path) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].bookName},#'{'list[{0}].category},#'{'list[{0}].path})");
        for (int i = 0; i < bookList.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < bookList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
```

### Select

#### Select
- BookMapper.java
```
    @Select("select book_name,category,path from book where book_name like concat('%',#{bookName},'%')")
    @Results({
            @Result(column = "book_name",property = "bookName"),
    })
    List<Book> selectBooks(@Param("bookName") String bookName);
```
