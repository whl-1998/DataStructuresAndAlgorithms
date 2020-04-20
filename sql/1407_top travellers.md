### 外连接 + 分组查询 + 分组函数sum

思路：

* 我们获取每一个用户的旅行距离，就意味着我们需要对检索结果按用户Id进行分组
* 其次，要求获取旅行距离的总和，因此通过 sum() 函数获取到 distance 的总和
* 最后排序，我们按照计算得到的 distance 降序排序，并按照名称升序排序

```mysql
select u.name name, ifnull(sum(r.distance), 0) travelled_distance 
from Users u left join Rides r on r.user_id = u.id
group by u.Id
order by travelled_distance desc, name asc;
```

