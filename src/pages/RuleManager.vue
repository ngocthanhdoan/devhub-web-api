<template>
    <div class="page__center">
        <div class="table-content">
            <div class="box-tab hidden-xs hidden-sm">
                <ul class="tab-menu-products">
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-1' }" @click="currentTab = 'tab-1'">
                        Danh sách quyền truy cập
                    </li>
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-2' }" @click="currentTab = 'tab-2'">
                        Thêm quyền truy cập mới
                    </li>
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-3' }" @click="currentTab = 'tab-3'">
                        Chỉnh sửa quyền truy cập
                    </li>
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-4' }" @click="currentTab = 'tab-4'">
                        Xóa quyền truy cập
                    </li>
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-5' }" @click="currentTab = 'tab-5'">
                        Cấp phép truy cập
                    </li>
                    <li class="menu-tab" :class="{ active: currentTab === 'tab-6' }" @click="currentTab = 'tab-6'">
                        Thiết lập vai trò và quyền hạn
                    </li>
                </ul>
            </div>
            <div class="list-tab efch-2 ef-img-t">
                <!-- Tab Danh sách quyền truy cập -->
                <div id="tab-1" v-show="currentTab === 'tab-1'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-1' }">
                    <h3>Danh sách quyền truy cập</h3>
                    <table class="table-check" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên quyền truy cập</th>
                                <th>Ngày tạo</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Admin</td>
                                <td>2024-08-01</td>
                                <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Editor</td>
                                <td>2024-08-05</td>
                                <td><a href="#">Chỉnh sửa</a> | <a href="#">Xóa</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- Tab Thêm quyền truy cập mới -->
                <div id="tab-2" v-show="currentTab === 'tab-2'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-2' }">
                    <h3>Thêm quyền truy cập mới</h3>
                    <form class="content_box_benefits">
                        <div class="row_box">
                            <div class="flex_group w-100">
                                <div class="input_group w-100">
                                    <div class="field_input">
                                        <label>Tên quyền truy cập</label>
                                    </div>
                                    <div class="field_input">
                                        <input class="w-100" type="text" name="access_name"
                                            placeholder="Nhập tên quyền truy cập" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row_box">
                            <div class="field_input">
                                <button type="submit">Thêm quyền truy cập</button>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Tab Chỉnh sửa quyền truy cập -->
                <div id="tab-3" v-show="currentTab === 'tab-3'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-3' }">
                    <h3>Chỉnh sửa quyền truy cập</h3>
                    <form class="content_box_benefits">
                        <div class="row_box">
                            <div class="flex_group w-100">
                                <div class="input_group w-100">
                                    <div class="field_input">
                                        <label>Tên quyền truy cập</label>
                                    </div>
                                    <div class="field_input">
                                        <input class="w-100" type="text" name="access_name" value="Admin" />
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

                <!-- Tab Xóa quyền truy cập -->
                <div id="tab-4" v-show="currentTab === 'tab-4'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-4' }">
                    <h3>Xóa quyền truy cập</h3>
                    <form class="content_box_benefits">
                        <div class="row_box">
                            <div class="flex_group w-100">
                                <div class="input_group w-100">
                                    <div class="field_input">
                                        <label>Chọn quyền truy cập để xóa</label>
                                    </div>
                                    <div class="field_input">
                                        <select class="w-100" name="delete_access">
                                            <option value="Admin">Admin</option>
                                            <option value="Editor">Editor</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row_box">
                            <div class="field_input">
                                <button type="submit">Xóa quyền truy cập</button>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Tab Cấp phép truy cập -->
                <div id="tab-5" v-show="currentTab === 'tab-5'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-5' }">
                    <h3>Cấp phép truy cập</h3>
                    <form class="content_box_benefits">
                        <div class="row_box">
                            <div class="flex_group w-100">
                                <div class="input_group w-50">
                                    <div class="field_input">
                                        <label>Tài khoản nhà phát triển</label>
                                    </div>
                                    <div class="field_input">
                                        <select class="w-100" name="developer_account">
                                            <option value="dev1">Developer 1</option>
                                            <option value="dev2">Developer 2</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="input_group w-50">
                                    <div class="field_input">
                                        <label>Cơ sở dữ liệu</label>
                                    </div>
                                    <div class="field_input">
                                        <select class="w-100" name="database">
                                            <option value="database1">database1</option>
                                            <option value="database2">database2</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row_box">
                            <div class="field_input">
                                <button type="submit">Cấp phép truy cập</button>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Tab Thiết lập vai trò và quyền hạn -->
                <div id="tab-6" v-show="currentTab === 'tab-6'"
                    :class="{ 'content-menu-products padding-x-16': true, 'active': currentTab === 'tab-6' }">
                    <h3>Thiết lập vai trò và quyền hạn</h3>
                    <form class="content_box_benefits">
                        <div class="row_box">
                            <div class="flex_group w-100">
                                <div class="input_group w-50">
                                    <div class="field_input">
                                        <label>Vai trò</label>
                                    </div>
                                    <div class="field_input">
                                        <input class="w-100" type="text" name="role_name" placeholder="Nhập vai trò" />
                                    </div>
                                </div>
                                <div class="input_group w-50">
                                    <div class="field_input">
                                        <label>Quyền hạn</label>
                                    </div>
                                    <div class="field_input">
                                        <input class="w-100" type="text" name="role_permissions"
                                            placeholder="Nhập quyền hạn" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row_box">
                            <div class="field_input">
                                <button type="submit">Lưu vai trò và quyền hạn</button>
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
            currentTab: 'tab-1',
        };
    },
};
</script>