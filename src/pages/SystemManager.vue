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
              Thiết lập kết nối máy chủ
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-2' }"
              @click="currentTab = 'tab-2'"
            >
              Thiết lập cấu hình cơ sở dữ liệu
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-3' }"
              @click="currentTab = 'tab-3'"
            >
              Thiết lập cấu hình tài khoản
            </li>
          </ul>
        </div>
        <div class="list-tab efch-2 ef-img-t">
          <!-- Tab Thiết lập kết nối máy chủ -->
          <div
            id="tab-1"
            v-show="currentTab === 'tab-1'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1'}"
          >
            <h3>Thiết lập kết nối máy chủ</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Địa chỉ máy chủ</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="server_address"
                        placeholder="Nhập địa chỉ máy chủ"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Cổng kết nối</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="port"
                        placeholder="Nhập cổng kết nối"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Lưu cấu hình</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Thiết lập cấu hình cơ sở dữ liệu -->
          <div
            id="tab-2"
            v-show="currentTab === 'tab-2'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2'}"
          >
            <h3>Thiết lập cấu hình cơ sở dữ liệu</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Tên cơ sở dữ liệu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="database_name"
                        placeholder="Nhập tên cơ sở dữ liệu"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Địa chỉ máy chủ</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="database_server_address"
                        placeholder="Nhập địa chỉ máy chủ cơ sở dữ liệu"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="flex_group w-50">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Tên người dùng</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_user"
                        placeholder="Nhập tên người dùng"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Mật khẩu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="password"
                        name="db_password"
                        placeholder="Nhập mật khẩu"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Lưu cấu hình</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Thiết lập cấu hình tài khoản -->
          <div
            id="tab-3"
            v-show="currentTab === 'tab-3'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3'}"
          >
            <h3>Thiết lập cấu hình tài khoản</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Tên tài khoản</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="account_name"
                        placeholder="Nhập tên tài khoản"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Địa chỉ email</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="email"
                        name="account_email"
                        placeholder="Nhập địa chỉ email"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="flex_group w-50">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Mật khẩu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="password"
                        name="account_password"
                        placeholder="Nhập mật khẩu"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Xác nhận mật khẩu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="password"
                        name="confirm_password"
                        placeholder="Xác nhận mật khẩu"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Lưu cấu hình</button>
                </div>
              </div>
            </form>
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
  