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
              Danh sách cơ sở dữ liệu
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-2' }"
              @click="currentTab = 'tab-2'"
            >
              Thêm cơ sở dữ liệu mới
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-3' }"
              @click="currentTab = 'tab-3'"
            >
              Chỉnh sửa cơ sở dữ liệu
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-4' }"
              @click="currentTab = 'tab-4'"
            >
              Xóa cơ sở dữ liệu
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-5' }"
              @click="currentTab = 'tab-5'"
            >
              Quản lý kết nối cơ sở dữ liệu
            </li>
          </ul>
        </div>
        <div class="list-tab efch-2 ef-img-t">
          <!-- Tab Danh sách cơ sở dữ liệu -->
          <div
            id="tab-1"
            v-show="currentTab === 'tab-1'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1'}"
          >
            <h3>Danh sách cơ sở dữ liệu</h3>
            <table class="table-check" border="0" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tên cơ sở dữ liệu</th>
                  <th>Ngày tạo</th>
                  <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>database1</td>
                  <td>2024-08-01</td>
                  <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>database2</td>
                  <td>2024-08-05</td>
                  <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                </tr>
              </tbody>
            </table>
          </div>
  
          <!-- Tab Thêm cơ sở dữ liệu mới -->
          <div
            id="tab-2"
            v-show="currentTab === 'tab-2'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2'}"
          >
            <h3>Thêm cơ sở dữ liệu mới</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Tên cơ sở dữ liệu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_name"
                        placeholder="Nhập tên cơ sở dữ liệu"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Thêm cơ sở dữ liệu</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Chỉnh sửa cơ sở dữ liệu -->
          <div
            id="tab-3"
            v-show="currentTab === 'tab-3'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3'}"
          >
            <h3>Chỉnh sửa cơ sở dữ liệu</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Tên cơ sở dữ liệu</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_name"
                        value="database1"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Lưu thay đổi</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Xóa cơ sở dữ liệu -->
          <div
            id="tab-4"
            v-show="currentTab === 'tab-4'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-4'}"
          >
            <h3>Xóa cơ sở dữ liệu</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Chọn cơ sở dữ liệu để xóa</label>
                    </div>
                    <div class="field_input">
                      <select
                        class="w-100"
                        name="delete_db"
                      >
                        <option value="database1">database1</option>
                        <option value="database2">database2</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Xóa cơ sở dữ liệu</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Quản lý kết nối cơ sở dữ liệu -->
          <div
            id="tab-5"
            v-show="currentTab === 'tab-5'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-5'}"
          >
            <h3>Quản lý kết nối cơ sở dữ liệu</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Host</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_host"
                        placeholder="Nhập host"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Port</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_port"
                        placeholder="Nhập port"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Username</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="db_username"
                        placeholder="Nhập username"
                      />
                    </div>
                  </div>
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Password</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="password"
                        name="db_password"
                        placeholder="Nhập password"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Lưu kết nối</button>
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
  
  <style scoped>
  /* Thêm các kiểu CSS tùy chỉnh của bạn tại đây */
  </style>
  