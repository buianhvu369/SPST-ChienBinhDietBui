**CHIẾN BINH DIỆT BỤI**

**1\. Thể loại**

- Mô phỏng, chiến lược, quản lý tài nguyên

**2\. Cốt truyện**

Thành phố đang chìm trong sương bụi mịn và khí độc do khí thải từ nhà máy, phương tiện giao thông và rác thải đốt ngoài trời. Người chơi vào vai một nhà khoa học trẻ tuổi, được giao nhiệm vụ làm sạch không khí, giảm ô nhiễm và cứu thành phố khỏi "Ngày Đen Tối" – khi chỉ số chất lượng không khí (AQI) vượt ngưỡng nguy hiểm.

**3\. Cách chơi**

**3.1 Mục tiêu chính**

- Giữ mức AQI dưới 100 (mức an toàn theo tiêu chuẩn WHO).
- Nếu AQI vượt mức 300, trò chơi kết thúc.
- AQI sẽ được tính toán dựa trên dữ liệu quan trắc thực tế từ các khu vực trong thành phố.

**3.2 Hệ thống tài nguyên**

| **Tài nguyên** | **Cách kiếm được** | **Cách sử dụng** |
| --- | --- | --- |
| 💰 Tiền | Thuế môi trường (5% GDP/ tháng), dự án nghiên cứu, tài trợ từ tổ chức môi trường | Dùng để mua thiết bị, nâng cấp công nghệ |
| ⚡ Năng lượng | Nhà máy điện xanh (+50 / tháng), năng lượng mặt trời (+30 mỗi / tháng) | Cung cấp cho các thiết bị lọc không khí, phương tiện giao thông |
| 🌿 Điểm xanh | Trồng cây (+10 mỗi cây) | Dùng để nâng cấp công nghệ xanh |

Thuế môi trường:

- GDP thành phố: 100,000(100 000 dân) 💰
- Thuế môi trường thu được mỗi : 5% GDP = 5,000 💰/ tháng
- Nếu AQI < 100, dân số tăng 2%.
- Nếu AQI > 200, dân số giảm 5% , thuế giảm theo.
- 1 biển báo đốt rác hoặc chặt cây giảm ngẫu nhiên (từ 0 đến 0.4% dân số/tháng nhưng sẽ tính theo ngày(chia theo ngày (chia cho 30 vì 1 tháng tính 30 ngày)) và hàng ngày sẽ cập nhật 1 random mới).

**3.3 Hệ thống nguồn ô nhiễm theo giờ**

Mỗi giờ, các nguồn ô nhiễm sẽ phát sinh hoặc thay đổi:

| **Thời gian** | **Nguồn ô nhiễm** | **Mức độ ảnh hưởng**  (trên 1 giờ)|
| --- | --- | --- |
| 06:00-09:00 | Giao thông cao điểm | +20 µg/m³ NO2, +15 µg/m³ CO |
| 10:00-12:00 | Hoạt động công nghiệp | +30 µg/m³ SO2, +20 µg/m³ PM2.5 |
| 12:00-14:00 | Ô nhiễm quang hóa | +25 µg/m³ O3 |
| 15:00-18:00 | Giao thông giờ cao điểm lần 2 | +20 µg/m³ NO2, +15 µg/m³ CO |
| 19:00-22:00 | Rác thải sinh hoạt đốt lộ thiên | +25 µg/m³ PM2.5, +20 µg/m³ SO2 |
| 22:00-06:00 | Hoạt động nhà máy liên tục | +20 µg/m³ PM10, +15 µg/m³ CO |

**3.4 Biện pháp giảm ô nhiễm theo giờ**

| **Biện pháp**                     | **Giảm nồng độ chất ô nhiễm mỗi giờ** | **Chi phí (💰)** | **Năng lượng (⚡)** | **Điểm xanh (🌿)** |  **Năng lượng hoạt động (⚡)** |
|-----------------------------------| --- | --- | --- | --- | --- |
| Một cái máy lọc không khí         | \-6 µg/m³ PM2.5, -4 µg/m³ NO2 | 500 | 20  | 0   | 5 |
| Một hệ thống giao thông xanh      | \-8 µg/m³ NO2, -6 µg/m³ CO | 1000 | 50  | 20  | 5 |
| Một level công nghệ sản xuất sạch | \-10 µg/m³ SO2, -8 µg/m³ NO2 | 1500 | 30  | 30  | 5 |
| Một cây xanh                      | \-0.2 µg/m³ PM10, -0.15 µg/m³ CO | 100 | 0   | 5   | 1$  |
| Một biển cấm đốt rác              | \-6 µg/m³ PM2.5, -5 µg/m³ SO2 | 300 | 10  | 5   | 1$  |

**4\. Tính toán gay cấn trong game**

**4.1 Trạng thái ban đầu**

- Quan trắc thực tế:
    - PM2.5 = 100 µg/m³ → AQI_PM2.5 = 180
    - PM10 = 150 µg/m³ → AQI_PM10 = 130
    - NO2 = 90 ppb → AQI_NO2 = 170
    - SO2 = 50 ppb → AQI_SO2 = 120
    - CO = 10 ppm → AQI_CO = 90
    - O3 = 80 ppb → AQI_O3 = 150
- AQI tổng hợp = max(180, 130, 170, 120, 90, 150) = 180 (Cực kỳ ô nhiễm)
- Tài nguyên: 💰5000, ⚡200, 🌿50

**4.2 Chiến lược ví dụ**

- Lắp 2 máy lọc không khí: Giảm 60% PM2.5, 40% NO2 → AQI_PM2.5 = 120, AQI_NO2 = 102 → Chi phí: 1000 💰, 40 ⚡
- Cấm đốt rác: Giảm 30% PM2.5, 25% SO2 → AQI_SO2 = 90 → Chi phí: 300 💰, 10 ⚡
- Xây 1 hệ thống giao thông xanh: Giảm 40% NO2, 30% CO → AQI_NO2 = 85, AQI_CO = 63 → Chi phí: 1000 💰, 50 ⚡, 20 🌿
- Tổng AQI mới: max(120, 130, 85, 90, 63, 150) = 150
- Kết quả: AQI vẫn nguy hiểm, người chơi cần tiếp tục đầu tư vào công nghệ xanh.
- Thách thức: Nếu nguồn ô nhiễm mới phát sinh (cháy rừng, sự cố nhà máy), AQI có thể tăng vọt, đòi hỏi phản ứng nhanh.

**5\. Ví dụ kịch bản 24 giờ**

**06:00 - 07:00**

- Giao thông tăng mạnh: +20 µg/m³ NO2, +15 µg/m³ CO
- Máy lọc không khí đang hoạt động: -6 µg/m³ PM2.5, -4 µg/m³ NO2
- AQI tăng nhẹ do NO2 tăng mạnh

**07:00 - 08:00**

- Giao thông vẫn ở mức cao: +20 µg/m³ NO2, +15 µg/m³ CO
- Hệ thống giao thông xanh giúp giảm: -8 µg/m³ NO2, -6 µg/m³ CO
- AQI tăng chậm hơn nhờ biện pháp giảm ô nhiễm

**08:00 - 09:00**

- Giao thông đạt đỉnh: +20 µg/m³ NO2, +15 µg/m³ CO
- Máy lọc không khí và giao thông xanh cùng tác động: -14 µg/m³ NO2, -10 µg/m³ CO
- AQI duy trì mức cao nhưng không vượt ngưỡng nguy hiểm

**09:00 - 10:00 (Yếu tố bất ngờ: Tai nạn giao thông lớn)**

- Tai nạn giao thông gây ùn tắc: +30 µg/m³ NO2, +20 µg/m³ CO
- Lượng phương tiện dừng chờ kéo dài làm tăng phát thải
- Các biện pháp giảm ô nhiễm vẫn hoạt động nhưng không đủ để bù đắp: -14 µg/m³ NO2, -10 µg/m³ CO
- AQI tăng vọt, người chơi phải tìm cách ứng phó khẩn cấp (ví dụ: tăng cường giao thông công cộng hoặc sử dụng biện pháp bổ sung)

**10:00 - 11:00**

- Hoạt động công nghiệp gia tăng: +30 µg/m³ SO2, +20 µg/m³ PM2.5
- Công nghệ sản xuất sạch giảm thiểu ô nhiễm: -10 µg/m³ SO2, -8 µg/m³ NO2
- AQI tiếp tục duy trì mức cao

**11:00 - 12:00 (Yếu tố bất ngờ: Cơn mưa bất chợt)**

- Mưa giúp rửa trôi bụi mịn: -15 µg/m³ PM2.5, -10 µg/m³ PM10
- Giảm đáng kể ô nhiễm không khí, AQI có xu hướng giảm

**12:00 - 13:00**

- Ô nhiễm quang hóa tăng do ánh sáng mạnh: +25 µg/m³ O3
- Không có biện pháp giảm trừ tức thời, AQI tăng trở lại

**13:00 - 14:00**

- Ô nhiễm quang hóa tiếp tục: +25 µg/m³ O3
- Cây xanh giúp giảm nhẹ tác động: -1 µg/m³ O3
- AQI vẫn cao do ảnh hưởng ozone

**14:00 - 15:00 (Yếu tố bất ngờ: Sự cố nhà máy điện xanh)**

- Nhà máy điện xanh bị gián đoạn, hệ thống lọc không khí hoạt động kém hơn
- AQI tăng nhanh hơn dự kiến

**15:00 - 16:00**

- Giờ cao điểm buổi chiều: +20 µg/m³ NO2, +15 µg/m³ CO
- Biện pháp giao thông xanh giúp giảm thiểu tác động

**16:00 - 17:00**

- Giao thông vẫn căng thẳng: +20 µg/m³ NO2, +15 µg/m³ CO
- AQI tiếp tục tăng nhẹ

**17:00 - 18:00**

- Giao thông giờ cao điểm tiếp tục: +20 µg/m³ NO2, +15 µg/m³ CO
- Các biện pháp giao thông xanh giúp giảm: -8 µg/m³ NO2, -6 µg/m³ CO
- AQI giữ mức cao nhưng không vượt ngưỡng nguy hiểm

**18:00 - 19:00 (Yếu tố bất ngờ: Sự kiện thể thao lớn)**

- Lượng phương tiện cá nhân tăng cao: +25 µg/m³ NO2, +20 µg/m³ CO
- Hệ thống lọc khí và giao thông xanh giảm nhẹ tác động: -14 µg/m³ NO2, -10 µg/m³ CO
- AQI tăng nhanh, người chơi phải tìm cách kiểm soát

**19:00 - 20:00**

- Đốt rác sinh hoạt lộ thiên gia tăng: +25 µg/m³ PM2.5, +20 µg/m³ SO2
- Biển cấm đốt rác giúp giảm: -6 µg/m³ PM2.5, -5 µg/m³ SO2
- AQI vẫn tăng do nguồn ô nhiễm mạnh

**20:00 - 21:00**

- Đốt rác tiếp tục: +25 µg/m³ PM2.5, +20 µg/m³ SO2
- Biện pháp kiểm soát chưa đủ mạnh, AQI tiếp tục tăng

**21:00 - 22:00 (Yếu tố bất ngờ: Mưa lớn)**

- Mưa giúp giảm bụi mịn: -15 µg/m³ PM2.5, -10 µg/m³ PM10
- AQI giảm đáng kể, mang lại cơ hội ổn định tình hình

**22:00 - 23:00**

- Nhà máy hoạt động ban đêm: +20 µg/m³ PM10, +15 µg/m³ CO
- Máy lọc không khí giúp giảm: -6 µg/m³ PM2.5, -4 µg/m³ NO2
- AQI tăng nhẹ nhưng vẫn trong tầm kiểm soát

**23:00 - 00:00**

- Nhà máy tiếp tục hoạt động mạnh: +20 µg/m³ PM10, +15 µg/m³ CO
- Người chơi có thể đầu tư thêm thiết bị lọc khí để kiểm soát ô nhiễm

**05:00 - 06:00**

- Hoạt động nhà máy giảm dần, giao thông sáng sớm bắt đầu: +10 µg/m³ NO2, +8 µg/m³ CO
- Biện pháp giảm ô nhiễm tiếp tục hoạt động.
- AQI sáng sớm có xu hướng cải thiện trước giờ cao điểm tiếp theo.
