
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
            Danh sách tài khoản
          </li>
          <li
            class="menu-tab"
            :class="{ active: currentTab === 'tab-2' }"
            @click="currentTab = 'tab-2'"
          >
            Thêm tài khoản mới
          </li>
          <li
            class="menu-tab"
            :class="{ active: currentTab === 'tab-3' }"
            @click="currentTab = 'tab-3'"
          >
            Chỉnh sửa tài khoản
          </li>
          <li
            class="menu-tab"
            :class="{ active: currentTab === 'tab-4' }"
            @click="currentTab = 'tab-4'"
          >
            Xóa tài khoản
          </li>
          <li
            class="menu-tab"
            :class="{ active: currentTab === 'tab-5' }"
            @click="currentTab = 'tab-5'"
          >
            Phân quyền tài khoản
          </li>
        </ul>
      </div>
      <div class="list-tab efch-2 ef-img-t">
        <!-- Tab Danh sách tài khoản -->
        <div
          id="tab-1"
          v-show="currentTab === 'tab-1'"
         :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1'}"
        >
          <h3>Danh sách tài khoản</h3>
          <table class="table-check" border="0" cellspacing="0" cellpadding="0">
            <thead>
              <tr>
                <th>ID</th>
                <th>Tên tài khoản</th>
                <th>Email</th>
                <th>Vai trò</th>
                <th>Hành động</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>dev_account1</td>
                <td>dev1@example.com</td>
                <td>Admin</td>
                <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
              </tr>
              <tr>
                <td>2</td>
                <td>dev_account2</td>
                <td>dev2@example.com</td>
                <td>Developer</td>
                <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
              </tr>
            </tbody>
          </table>
        </div>

        <!-- Tab Thêm tài khoản mới -->
        <div
          id="tab-2"
          v-show="currentTab === 'tab-2'"
:class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2'}"
        >
          <h3>Thêm tài khoản mới</h3>
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
                      name="username"
                      placeholder="Nhập tên tài khoản"
                    />
                  </div>
                </div>
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Email</label>
                  </div>
                  <div class="field_input">
                    <input
                      class="w-100"
                      type="email"
                      name="email"
                      placeholder="Nhập email"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="flex_group w-100">
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Mật khẩu</label>
                  </div>
                  <div class="field_input">
                    <input
                      class="w-100"
                      type="password"
                      name="password"
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
                      placeholder="Nhập lại mật khẩu"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="field_input">
                <button type="submit">Thêm tài khoản</button>
              </div>
            </div>
          </form>
        </div>

        <!-- Tab Chỉnh sửa tài khoản -->
        <div
          id="tab-3"
          v-show="currentTab === 'tab-3'"
       :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3'}"
        >
          <h3>Chỉnh sửa tài khoản</h3>
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
                      name="username"
                      value="dev_account1"
                    />
                  </div>
                </div>
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Email</label>
                  </div>
                  <div class="field_input">
                    <input
                      class="w-100"
                      type="email"
                      name="email"
                      value="dev1@example.com"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="flex_group w-100">
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Mật khẩu mới</label>
                  </div>
                  <div class="field_input">
                    <input
                      class="w-100"
                      type="password"
                      name="new_password"
                      placeholder="Nhập mật khẩu mới"
                    />
                  </div>
                </div>
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Xác nhận mật khẩu mới</label>
                  </div>
                  <div class="field_input">
                    <input
                      class="w-100"
                      type="password"
                      name="confirm_new_password"
                      placeholder="Nhập lại mật khẩu mới"
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

        <!-- Tab Xóa tài khoản -->
        <div
          id="tab-4"
          v-show="currentTab === 'tab-4'"
               :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-4'}"
        >
          <h3>Xóa tài khoản</h3>
          <form class="content_box_benefits">
            <div class="row_box">
              <div class="flex_group w-100">
                <div class="input_group w-100">
                  <div class="field_input">
                    <label>Chọn tài khoản để xóa</label>
                  </div>
                  <div class="field_input">
                    <select
                      class="w-100"
                      name="delete_account"
                    >
                      <option value="dev_account1">dev_account1</option>
                      <option value="dev_account2">dev_account2</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="field_input">
                <button type="submit">Xóa tài khoản</button>
              </div>
            </div>
          </form>
        </div>

        <!-- Tab Phân quyền tài khoản -->
        <div
          id="tab-5"
          v-show="currentTab === 'tab-5'"
                :class="{'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-5'}"
        >
          <h3>Phân quyền tài khoản</h3>
          <form class="content_box_benefits">
            <div class="row_box">
              <div class="flex_group w-100">
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Chọn tài khoản</label>
                  </div>
                  <div class="field_input">
                    <select
                      class="w-100"
                      name="account_to_role"
                    >
                      <option value="dev_account1">dev_account1</option>
                      <option value="dev_account2">dev_account2</option>
                    </select>
                  </div>
                </div>
                <div class="input_group w-50">
                  <div class="field_input">
                    <label>Chọn vai trò</label>
                  </div>
                  <div class="field_input">
                    <select
                      class="w-100"
                      name="role"
                    >
                      <option value="Admin">Admin</option>
                      <option value="Developer">Developer</option>
                      <option value="Viewer">Viewer</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <div class="row_box">
              <div class="field_input">
                <button type="submit">Phân quyền</button>
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