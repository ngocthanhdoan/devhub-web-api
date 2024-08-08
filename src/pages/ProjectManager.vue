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
              Danh sách dự án
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-2' }"
              @click="currentTab = 'tab-2'"
            >
              Thêm dự án mới
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-3' }"
              @click="currentTab = 'tab-3'"
            >
              Chỉnh sửa dự án
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-4' }"
              @click="currentTab = 'tab-4'"
            >
              Xóa dự án
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-5' }"
              @click="currentTab = 'tab-5'"
            >
              Thiết lập cơ sở dữ liệu cho dự án
            </li>
            <li
              class="menu-tab"
              :class="{ active: currentTab === 'tab-6' }"
              @click="currentTab = 'tab-6'"
            >
              Thiết lập quyền truy cập cho dự án
            </li>
          </ul>
        </div>
        <div class="list-tab efch-2 ef-img-t">
          <!-- Tab Danh sách dự án -->
          <div
            id="tab-1"
            v-show="currentTab === 'tab-1'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1'}"
          >
            <h3>Danh sách dự án</h3>
            <table class="table-check" border="0" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tên dự án</th>
                  <th>Ngày tạo</th>
                  <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Project Alpha</td>
                  <td>2024-08-01</td>
                  <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Project Beta</td>
                  <td>2024-08-05</td>
                  <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                </tr>
              </tbody>
            </table>
          </div>
  
          <!-- Tab Thêm dự án mới -->
          <div
            id="tab-2"
            v-show="currentTab === 'tab-2'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2'}"
          >
            <h3>Thêm dự án mới</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Tên dự án</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="project_name"
                        placeholder="Nhập tên dự án"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Thêm dự án</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Chỉnh sửa dự án -->
          <div
            id="tab-3"
            v-show="currentTab === 'tab-3'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3'}"
          >
            <h3>Chỉnh sửa dự án</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Tên dự án</label>
                    </div>
                    <div class="field_input">
                      <input
                        class="w-100"
                        type="text"
                        name="project_name"
                        value="Project Alpha"
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
  
          <!-- Tab Xóa dự án -->
          <div
            id="tab-4"
            v-show="currentTab === 'tab-4'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-4'}"
          >
            <h3>Xóa dự án</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Chọn dự án để xóa</label>
                    </div>
                    <div class="field_input">
                      <select
                        class="w-100"
                        name="delete_project"
                      >
                        <option value="Project Alpha">Project Alpha</option>
                        <option value="Project Beta">Project Beta</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="field_input">
                  <button type="submit">Xóa dự án</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Thiết lập cơ sở dữ liệu cho dự án -->
          <div
            id="tab-5"
            v-show="currentTab === 'tab-5'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-5'}"
          >
            <h3>Thiết lập cơ sở dữ liệu cho dự án</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Chọn dự án</label>
                    </div>
                    <div class="field_input">
                      <select
                        class="w-100"
                        name="project_select"
                      >
                        <option value="Project Alpha">Project Alpha</option>
                        <option value="Project Beta">Project Beta</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-50">
                    <div class="field_input">
                      <label>Chọn cơ sở dữ liệu</label>
                    </div>
                    <div class="field_input">
                      <select
                        class="w-100"
                        name="database_select"
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
                  <button type="submit">Lưu cài đặt</button>
                </div>
              </div>
            </form>
          </div>
  
          <!-- Tab Thiết lập quyền truy cập cho dự án -->
          <div
            id="tab-6"
            v-show="currentTab === 'tab-6'"
            :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-6'}"
          >
            <h3>Thiết lập quyền truy cập cho dự án</h3>
            <form class="content_box_benefits">
              <div class="row_box">
                <div class="flex_group w-100">
                  <div class="input_group w-100">
                    <div class="field_input">
                      <label>Chọn dự án</label>
                    </div>
                    <div class="field_input">
                      <select
                        class="w-100"
                        name="project_select_permission"
                      >
                        <option value="Project Alpha">Project Alpha</option>
                        <option value="Project Beta">Project Beta</option>
                      </select>
                    </div>
                  </div>
               
                </div>
            </div>
            <div class="row_box">
              <div class="flex_group w-100">
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Chọn quyền truy cập</label>
                  </div>
                  <div class="field_input">
                    <select
                      class="w-100"
                      name="permission_select"
                    >
                      <option value="Read">Đọc</option>
                      <option value="Write">Ghi</option>
                      <option value="Admin">Quản trị</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="field_input">
                <button type="submit">Cấp quyền</button>
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