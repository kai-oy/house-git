package com.example.house.Dao;

import com.example.house.Entity.House;
import com.example.house.Entity.HouseVoAllTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @return 查询house表中所有数据
     */
    public List<House> queryHouse() {
        String sql = "select * from House";
        List<House> houseList = null;
        try {
            houseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(House.class));
        } catch (EmptyResultDataAccessException e) {

        }
        return houseList;
    }

    /**
     * 内连接street，users，housetype，disstrict 根据条件查询house表中数据详细信息
     * @param price       价格
     * @param uId         那个用户发布的
     * @param title       标题
     * @param streetid    区分
     * @param districtId  街道
     * @param houseTypeId 户型
     * @param floorage    面积
     * @return
     */
    public List<HouseVoAllTable> queryHouseConAllTable(int rownum, int price, int uId, String title, int streetid, int districtId, int houseTypeId, int floorage) {
        String sql = "select u.id as userid,house.id as id, contact,u.username,user_id,title,description,price,pubdate,h.name as typeName,s.name as streetName,d.id as distriId ,d.name as distriName,floorage from house " +
                "inner join housetype as h  on house.type_id=h.id " +
                "inner join street as s on house.street_id = s.id " +
                "inner join district as d on s.district_id = d.id " +
                "inner join users as u on house.user_id=u.id where 1=1";
        List<HouseVoAllTable> houseList = null;
        Object[] obj = new Object[8];//存储SQL条件值
        int index = 0;//记载SQL条件顺序
        if (uId != 0) {
            obj[index] = uId;
            sql = sql + "  and user_id = ?";
            index++;
        }

        if (price != 0) {
            obj[index] = price;
            sql = sql + "  and price = ?";
            index++;
        }

        if (title != null && !"".equals(title)) {
            obj[index] = "%" + title + "%";
            sql = sql + "  and title like ?";
            index++;
        }
        if (streetid != 0) {
            obj[index] = streetid;
            sql = sql + "  and street_id = ?";
            index++;
        }
        if (districtId != 0) {
            obj[index] = districtId;
            sql = sql + "  and district_Id = ?";
            index++;
        }
        if (houseTypeId != 0) {
            obj[index] = houseTypeId;
            sql = sql + "  and Type_Id = ?";
            index++;
        }
        if (floorage != 0) {
            obj[index] = floorage;
            sql = sql + "  and floorage = ?";
            index++;
        }

        obj[index] = rownum;
        sql = sql + "  limit ?,4";
        index++;

        Object[] objSql = new Object[index];
        System.arraycopy(obj, 0, objSql, 0, index);
        try {
            houseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HouseVoAllTable.class), objSql);
        } catch (EmptyResultDataAccessException e) {

        }
        return houseList;
    }

    /**
     * @return 查询house表中所有价位 分组去除重复
     */
    public List<House> queryHouseByPrice() {
        String sql = "select price from House group by  price ORDER BY price";
        List<House> houseList = null;
        try {
            houseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(House.class));
        } catch (EmptyResultDataAccessException e) {

        }
        return houseList;
    }

    /**
     * @return 查询house表中所有面积 分组去除重复
     */
    public List<House> queryHouseByFloorage() {
        String sql = "select FLOORAGE from House group by  FLOORAGE ORDER by FLOORAGE";
        List<House> houseList = null;
        try {
            houseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(House.class));
        } catch (EmptyResultDataAccessException e) {

        }
        return houseList;
    }

    /**
     * @param id 根据house表中ID值查询数据
     * @return
     */
    public House queryHouseId(int id) {
        String sql = "select * from House inner join street as s on house.street_id=s.id  where house.id = ?";
        House house = null;
        try {
            house = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(House.class), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return house;
    }

    /**
     * @param house house表添加数据
     * @return
     */
    public int addHouse(House house) {
        String sql = "insert into House( USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,PUBDATE,FLOORAGE,CONTACT,STREET_ID ) value (?,?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, house.getUserId(), house.getTypeId(), house.getTitle(), house.getDescription(), house.getPrice(), house.getPubDate(), house.getFloorage(), house.getContact(), house.getStreetId());
        return i;
    }

    /**
     * @param house 按id修改house表中数据
     * @return
     */
    public int updateHouse(House house) {
        String sql = "update House set TYPE_ID=?,TITLE=?,DESCRIPTION=?,PRICE=?,PUBDATE=?,FLOORAGE=?,CONTACT=?,STREET_ID=? where id=?";
        int i = jdbcTemplate.update(sql, house.getTypeId(), house.getTitle(), house.getDescription(), house.getPrice(), house.getPubDate(), house.getFloorage(), house.getContact(), house.getStreetId(),house.getId());
        return i;
    }

    public int daleteHouse(String id) {
        String sql = "delete from House where id=? ";
        int i = jdbcTemplate.update(sql, id);
        return i;
    }

    /**根据条件查询house表中分页后数据页数最大值
     * @param price
     * @param uId
     * @param title
     * @param streetid
     * @param districtId
     * @param houseTypeId
     * @param floorage
     * @return
     */
    public int countHouseNumber(int price, int uId, String title, int streetid, int districtId, int houseTypeId, int floorage) {
        String sql = "select count(1) as sum  from house \n" +
                "inner join street as s on house.street_id = s.id  where 1 = ?";
        Object[] obj = new Object[9];//存储SQL条件值
        int index = 0;//记载SQL条件顺序
        obj[index] = 1;
        index++;
        if (uId != 0) {
            obj[index] = uId;
            sql = sql + "  and user_id = ?";
            index++;
        }

        if (price != 0) {
            obj[index] = price;
            sql = sql + "  and price = ?";
            index++;
        }

        if (title != null && !"".equals(title)) {
            obj[index] = "%" + title + "%";
            sql = sql + "  and title like ?";
            index++;
        }
        if (streetid != 0) {
            obj[index] = streetid;
            sql = sql + "  and street_id = ?";
            index++;
        }
        if (districtId != 0) {
            obj[index] = districtId;
            sql = sql + "  and district_Id = ?";
            index++;
        }
        if (houseTypeId != 0) {
            obj[index] = houseTypeId;
            sql = sql + "  and Type_Id = ?";
            index++;
        }
        if (floorage != 0) {
            obj[index] = floorage;
            sql = sql + "  and floorage = ?";
            index++;
        }

        Object[] objSql = new Object[index];
        System.arraycopy(obj, 0, objSql, 0, index);
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, objSql);
        return integer;
    }
}
