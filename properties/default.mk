#
# Copyright (C) 2022,bigsaltyfishes <bigsaltyfishes@gmail.com>
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

PRODUCT_DEFAULT_PROPERTY_OVERRIDES += \
	ro.surface_flinger.has_wide_color_display=true
	ro.surface_flinger.has_HDR_display=true
	ro.surface_flinger.use_color_management=true
	ro.surface_flinger.wcg_composition_dataspace=143261696
	ro.surface_flinger.protected_contents=true
	ro.surface_flinger.set_touch_timer_ms=200
	ro.surface_flinger.force_hwc_copy_for_virtual_displays=true
