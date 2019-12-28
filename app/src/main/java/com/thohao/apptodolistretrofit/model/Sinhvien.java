package com.thohao.apptodolistretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sinhvien {

@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("yearofbirth")
@Expose
private String yearofbirth;
@SerializedName("address")
@Expose
private String address;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getYearofbirth() {
return yearofbirth;
}

public void setYearofbirth(String yearofbirth) {
this.yearofbirth = yearofbirth;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

}