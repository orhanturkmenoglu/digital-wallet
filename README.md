💼 Digital Wallet - Dijital Cüzdan Mikroservis Platformu
⚙️ Kurulum
# 1. Projeyi klonla
git clone [https://github.com/orhancgr/spring-finwallet.git](https://github.com/orhanturkmenoglu/digital-wallet.git)

cd spring-finwallet

# 2. Docker ile başlat
docker-compose up --build


## 🧠 Proje Hakkında

**DigitalWallet**, geleneksel bankacılığı dijital dünyanın kolaylığıyla buluşturan, entegre finansal hizmetler sunan bir süper uygulamadır. Kullanıcılar sadece dijital cüzdan işlemleri yapmakla kalmaz, aynı zamanda bankalar ve ATM’lerle doğrudan etkileşime geçerek fiziksel-dijital geçişi kolayca yönetebilirler.

**DigitalWallet**, modern dijital cüzdan ihtiyaçlarını karşılamak üzere tasarlanmış, ölçeklenebilir ve güvenli bir **mikroservis mimarisi** üzerine inşa edilmiştir. Spring Boot, Kafka, Redis, Docker ve diğer endüstri standartlarıyla hazırlanmış bu projede, kullanıcılar hesap açabilir, para transferi yapabilir, kart oluşturabilir ve çok daha fazlasını gerçekleştirebilir.

---

## 🏗️ Mikroservis Mimarisi

### 🔐 Auth Service ✅
- Kullanıcı doğrulama (JWT / OAuth2)
- Rol bazlı yetkilendirme (USER, ADMIN)
- Kayıt / Giriş / Şifre sıfırlama

### 👤 User Service ✅
- Profil görüntüleme ve güncelleme
- E-posta doğrulama
- Şifre değişimi

### 👥 Customer Service ✅
- Gerçek müşteri verisi (KYC)
- TCKN ve MERNİS doğrulama
- Bireysel / Kurumsal ayrımı

### 💳 Account Service ✅
- IBAN oluşturma
- Çoklu döviz tipi (TRY, USD, EUR)
- Hesap hareketleri

### 💳 Card Service ✅
- Sanal / fiziksel kart üretimi
- PAN, CVC, SKT bilgileri
- Kart ile ödeme

### 💸 Transaction Service ✅
- Havale / EFT / FAST işlemleri
- Cüzdan ve hesap arası transfer
- İşlem geçmişi

### 🏧 ATM Service ✅
- Para yatırma / çekme
- QR ile işlem (opsiyonel)
- Simülasyon modu

### 🏦 Bank Service ✅
- Banka kodları, SWIFT bilgileri
- IBAN doğrulama
- Harici hesaplarla etkileşim

---

## 📦 Ek Servisler

### 💼 Wallet Service 🆕
- Dijital cüzdan işlemleri
- Para yatırma / çekme
- Cüzdanlar arası transfer

### 🔔 Notification Service 🆕
- E-posta & SMS bilgilendirme
- Kafka ile event tabanlı yapı
- Kullanıcıya anlık geri dönüş

### 📊 Audit Service 🆕
- Aksiyon loglama
- Kim, ne zaman, ne yaptı?
- Uyum ve izleme gereksinimi

### 🛠️ Admin Service 🆕
- Admin panel & analiz
- Hesap / müşteri dondurma
- Kullanıcı istatistikleri

---

## 🌐 Ortak Altyapılar

| Bileşen | Açıklama |
|--------|----------|
| **API Gateway** | Tüm servislere dış dünyadan tek giriş noktası |
| **Service Discovery (Eureka)** | Servislerin birbirini keşfetmesini sağlar |
| **Config Server** | Tüm servisler için merkezi yapılandırma |
| **Kafka / RabbitMQ** | Asenkron iletişim / Event Driven Architecture |
| **Redis** | Cacheleme ve performans optimizasyonu |
| **Grafana + Prometheus** | Gerçek zamanlı izleme ve metrik takibi |
| **Zipkin** | Dağıtık izleme ve trace analizi |

---

## 🚀 Teknolojiler

- **Java 17**
- **Spring Boot 3.x**
- **Spring Cloud (Eureka, Gateway, Config)**
- ** Spring Security 🔐**
- **Kafka / RabbitMQ**
- **Redis**
- **PostgreSQL / MongoDB**
- **Docker / Docker Compose**
- **Grafana / Prometheus / Zipkin**
- **JUnit / Testcontainers / Mockito**

---

🛡️ Güvenlik
JWT ile kimlik doğrulama

Rol bazlı yetkilendirme

HTTPS yapılandırması (opsiyonel)

Rate Limiting (Resilience4J)
---

🧪 Testler
Birim Testler (JUnit, Mockito)

Entegrasyon Testleri (Testcontainers)

Contract Test (Spring Cloud Contract - opsiyonel)

---
🧩 Katkı Sağlamak
Forkla 🚀

Yeni bir feature branch aç

Kodunu geliştir ve test et

Pull Request gönder ✨

---

📅 Yol Haritası
 Temel servislerin kurulumu

 Wallet, Notification, Audit, Admin servisleri

 Swagger/OpenAPI dökümantasyonu

 CI/CD pipeline (GitHub Actions)

 Web Uygulama (ReactJs)
