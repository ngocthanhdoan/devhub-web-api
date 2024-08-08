<template>
  <div :class="pageClass">
    <div class="page__content">
      <SideBarComponent :sidebarClass="sidebarClass" />
      <div class="page__wrapper">
        <HeaderComponent @toggleSidebar="toggleSidebar" />
        <router-view />
        <FooterComponent />
      </div>
     
    </div>
  </div>
</template>

<script>
import SideBarComponent from "./components/SideBar.vue";
import HeaderComponent from "./components/Header.vue";
import FooterComponent from "./components/Footer.vue";

export default {
  name: "Mainpage",
  components: {
    SideBarComponent,
    HeaderComponent,
    FooterComponent,
  },
  data() {
    return {
      isSidebarActive: false,
    };
  },
  computed: {
    pageClass() {
      return this.isSidebarActive ? 'page toggle' : 'page';
    },
    sidebarClass() {
      return this.isSidebarActive ? 'sidebar active' : 'sidebar';
    },
  },
  methods: {
    toggleSidebar() {
      this.isSidebarActive = !this.isSidebarActive;
    },
  },
};
</script>
