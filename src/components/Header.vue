<template>
    <div class="header">
        <button class="sidebar__burger" @click="$emit('toggleSidebar')">
            <img src="../assets/img/icon/menu.svg" alt="" />
        </button>
        <a class="sidebar__logo hidden-lg" href="index-2.html">
            <img class="sidebar__pic sidebar__pic_black" src="../assets/images/icon_hide.png" alt="" />
        </a>
        <div class="info-head hidden-xs hidden-sm">
            <div class="text-info-head">
                <img src="../assets/images/volume-low.svg" alt="" /> Chào <span>Việt Trần,</span> bạn có <span> 4
                </span> hợp đồng bảo hiểm
            </div>
        </div>
        <div class="header__control">
            <div class="header__item header__item_add js-header-item">
                <button class="header__head js-header-head">
                    <svg class="icon" width="24" height="24" viewBox="0 0 24 24" fill="none"
                        xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M11.5 21.75C5.85 21.75 1.25 17.15 1.25 11.5C1.25 5.85 5.85 1.25 11.5 1.25C17.15 1.25 21.75 5.85 21.75 11.5C21.75 17.15 17.15 21.75 11.5 21.75ZM11.5 2.75C6.67 2.75 2.75 6.68 2.75 11.5C2.75 16.32 6.67 20.25 11.5 20.25C16.33 20.25 20.25 16.32 20.25 11.5C20.25 6.68 16.33 2.75 11.5 2.75Z"
                            fill="" />
                        <path
                            d="M21.9999 22.75C21.8099 22.75 21.6199 22.68 21.4699 22.53L19.4699 20.53C19.1799 20.24 19.1799 19.76 19.4699 19.47C19.7599 19.18 20.2399 19.18 20.5299 19.47L22.5299 21.47C22.8199 21.76 22.8199 22.24 22.5299 22.53C22.3799 22.68 22.1899 22.75 21.9999 22.75Z"
                            fill="" />
                    </svg>
                </button>
                <div class="header__body js-header-body">
                    <form action="#">
                        <button>
                            <img src="../assets/img/icon/search-black.svg" alt="search" />
                        </button>
                        <input class="header__input" type="text" placeholder="Tìm kiếm" />
                    </form>
                </div>
            </div>
            <div class="header__item header__item_notifications js-header-item">
                <button class="header__head js-header-head active">
                    <img src="../assets/images/sms-notification.svg" alt="" />
                </button>
                <div class="header__body js-header-body">
                    <div class="notifications">
                        <div class="notifications__info h6">Thông báo</div>
                        <div class="notifications__list">
                            <a class="notifications__item" href="#">
                                <div class="notifications__details">
                                    <div class="notifications__line">
                                        Thông báo đóng hồ sơ
                                    </div>
                                    <div class="notifications__text">
                                        Lorem ipsum dolor sit amet consectetur. Ultrices tellus nisl adipiscing proin
                                        proin arcu convallis mattis. Eget nisl tristique aliquam id mus venenatis ligula
                                        in. ate luctus gravida...
                                    </div>
                                </div>
                            </a>
                            <a class="notifications__item" href="#">
                                <div class="notifications__details">
                                    <div class="notifications__line">
                                        Thông báo đóng hồ sơ
                                    </div>
                                    <div class="notifications__text">
                                        Lorem ipsum dolor sit amet consectetur. Ultrices tellus nisl adipiscing proin
                                        proin arcu convallis mattis. Eget nisl tristique aliquam id mus venenatis ligula
                                        in. ate luctus gravida...
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="btn-view">
                            <a href="notification.html">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header__item header__item_add js-header-item">
                <a href="login.html" class="login__ava">
                    <img src="../assets/images/user.png" alt="" />
                </a>
            </div>
            <div class="lang-sel">
                <div class="header__head js-header-head">
                    <img src="../assets/images/vn.svg" alt="" />
                </div>
                <ul>
                    <li><a href="#"><img src="../assets/img/icon/vn.png" alt="vn">VN</a></li>
                    <li><a href="#"><img src="../assets/img/icon/gb.png" alt="en">EN</a></li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: "HeaderComponent",
};
</script>