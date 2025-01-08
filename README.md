# Spaceflight News App

Bu uygulama, Spaceflight News API'sinden uzay uçuşları ile ilgili son haberleri çeker ve kullanıcıların bu haberleri görmesine olanak tanır. Uygulama, haberlerin başlıkları, özetleri, yayınlanma tarihleri ile birlikte bir ana ekran ve detaylı makale görüntüleme sayfası sunmaktadır.

## Özellikler

- **API Entegrasyonu:**
  - Spaceflight News API'sini kullanarak son uzay uçuşu haberlerini alır.
  - API Base URL: [https://api.spaceflightnewsapi.net/v4/] (https://api.spaceflightnewsapi.net/v4/)

- **Ana Ekran:**
  - Son uzay uçuşu haberlerinin bir listesini görüntüler.
  - Her liste öğesi haberin başlığı, özeti ve yayınlanma tarihini gösterir.

- **Detaylı Makale Görünümü:**
  - Kullanıcıların bir haberin üzerine tıklayarak detaylarını görüntülemelerini sağlar.
  - Makalenin başlığını, özetini, yayınlanma tarihini ve ilgili görselleri gösterir.

## Kullanım

1. **Proje İndirildiğinde:**
   - İlk olarak projeyi bilgisayarınıza indirin.
   - Android Studio'yu açarak projeyi açın.

2. **API Anahtarı ve Bağlantılar:**
   - API bağlantısı herhangi bir özel API anahtarı gerektirmez. Ancak internet bağlantınızın aktif olduğundan emin olun.

3. **Projenin Çalıştırılması:**
   - Android Studio üzerinden projeyi çalıştırarak, uygulamayı cihazınızda veya emülatörde test edebilirsiniz.

## Teknolojiler

- **Android Studio**
- **Kotlin**
- **Jetpack Compose** (UI için)
- **Retrofit** (API Entegrasyonu için)
- **Gson** (JSON verilerini işlemek için)

## Kurulum

1. Android Studio'yu açın ve "Spaceflight News App" projesini klonlayın.
2. Uygulamayı çalıştırmak için `gradle` yapılandırma dosyalarını ve bağımlılıkları güncel tutun.
3. Uygulamayı Android cihazında veya emülatörde başlatın.
