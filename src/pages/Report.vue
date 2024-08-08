<template>
    <div class="page__center">
      <div class="table-content">
        <div class="box-tab hidden-xs hidden-sm">
          <ul class="tab-menu-products">
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-1' }"
              @click="currentTab = 'tab-1'"
            >
              Thống kê truy cập
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-2' }"
              @click="currentTab = 'tab-2'"
            >
              Báo cáo sử dụng
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-3' }"
              @click="currentTab = 'tab-3'"
            >
              Lịch sử hoạt động
            </li>
          </ul>
        </div>
        <div class="list-tab efch-2 ef-img-t">
          <!-- Tab Thống kê truy cập -->
          <div
            id="tab-1"
            v-show="currentTab === 'tab-1'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1'}"
          >
            <h3>Thống kê truy cập</h3>
            <table class="table-check" border="0" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th>Tài khoản</th>
                  <th>Địa chỉ IP</th>
                  <th>Thời gian truy cập</th>
                  <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>user1</td>
                  <td>192.168.1.1</td>
                  <td>2024-08-08 10:00:00</td>
                  <td><a href="#">Chi tiết</a></td>
                </tr>
                <tr>
                  <td>user2</td>
                  <td>192.168.1.2</td>
                  <td>2024-08-08 11:00:00</td>
                  <td><a href="#">Chi tiết</a></td>
                </tr>
              </tbody>
            </table>
          </div>
  
          <!-- Tab Báo cáo sử dụng -->
          <div
            id="tab-2"
            v-show="currentTab === 'tab-2'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2'}"
          >
            <h3>Báo cáo sử dụng</h3>
            <table class="table-check" border="0" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th>Tài khoản</th>
                  <th>Tên cơ sở dữ liệu</th>
                  <th>Thời gian sử dụng</th>
                  <th>Khối lượng dữ liệu</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>user1</td>
                  <td>database1</td>
                  <td>2024-08-08 10:30:00</td>
                  <td>500 MB</td>
                </tr>
                <tr>
                  <td>user2</td>
                  <td>database2</td>
                  <td>2024-08-08 11:30:00</td>
                  <td>300 MB</td>
                </tr>
              </tbody>
            </table>
          </div>
  
          <!-- Tab Lịch sử hoạt động -->
          <div
            id="tab-3"
            v-show="currentTab === 'tab-3'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3'}"
          >
            <h3>Lịch sử hoạt động</h3>
            <table class="table-check" border="0" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th>Tài khoản</th>
                  <th>Hành động</th>
                  <th>Thời gian</th>
                  <th>Ghi chú</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>user1</td>
                  <td>Đăng nhập</td>
                  <td>2024-08-08 10:00:00</td>
                  <td>Đăng nhập thành công</td>
                </tr>
                <tr>
                  <td>user2</td>
                  <td>Thay đổi mật khẩu</td>
                  <td>2024-08-08 11:00:00</td>
                  <td>Thay đổi mật khẩu thành công</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        currentTab: 'tab-1', // Tab mặc định khi mở trang
      };
    },
  };
  </script>
  