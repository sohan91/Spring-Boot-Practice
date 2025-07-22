package com.basic.Basic.dao;

import java.util.List;

public interface AccountDAO {
   public void addAccount();
   public void setName(String name);
   public String getName();
   void accountHolders(List<String> holders);
   List<String> returnHolders();
}
