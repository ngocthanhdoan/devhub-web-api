<template>
  <div  :class="sidebarClass">
      <div class="sidebar__top">
          <!-- <router-link class="sidebar__logo" to="/">
              <img class="sidebar__pic sidebar__pic_black" src="../assets/images/Logo.png" alt="" />
          </router-link>
          <router-link class="sidebar__logo_short" to="/">
              <img src="../assets/images/icon_hide.png" alt="logo" />
          </router-link> -->
      </div>
      <div class="sidebar__wrapper">
          <div class="header__body js-header-body">
              <form action="#">
                  <button>
                      <img src="../assets/img/icon/search-black.svg" alt="search" />
                  </button>
                  <input class="header__input" type="text" placeholder="Tìm kiếm" />
              </form>
          </div>
          <div class="info-head hidden-md hidden-lg">
              <div class="text-info-head">
                  <img src="../assets/images/volume-low.svg" alt="" /> 
                  <p>Chào <span>Việt Trần,</span> bạn có <span> 4 </span> hợp đồng bảo hiểm</p>
              </div>
          </div>
          <div class="sidebar__inner">
              <div class="sidebar__group">
                  <div class="sidebar__menu">
                      <router-link class="sidebar__item" to="/" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/home.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text">  {{ $translate("page_sidebar_01") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/manager_account" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_02") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/manager_database" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_03") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/manager_rule" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_04") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/manager_project" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_05") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/manager_system" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_06") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/report" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_07") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_08") }}</div>
                      </router-link>
                      <router-link class="sidebar__item" to="/contract" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img class="icon" src="../assets/img/icon/contract.svg" alt="" /> 
                          </div>
                          <div class="sidebar__text"> {{ $translate("page_sidebar_09") }}</div>
                      </router-link>
                  </div>
              </div>
          </div>
      </div>
      <div class="sidebar__bottom">
          <div class="sidebar__inner">
              <div class="sidebar__group">
                  <div class="sidebar__menu">
                      <router-link class="sidebar__item" to="/form" exact-active-class="active">
                          <div class="sidebar__icon">
                              <img src="../assets/img/icon/import.svg" alt="" />
                          </div>
                          <div class="sidebar__text">Tải biểu mẫu thông dụng</div>
                      </router-link>
                  </div>
              </div>
          </div>
      </div>
  </div>
  
</template>

<script>
export default {
  name: "SideBarComponent",
  props: {
    sidebarClass: {
      type: String,
      required: true,
    },
  },
};
</script>
<style scoped>
/* Thêm CSS cho lớp 'active' nếu cần */
.sidebar__item.active {
  background-color: #f0f0f0;
}
</style>
