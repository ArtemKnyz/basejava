/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[1000];
    int sizeResume;

    void clear() {
        for (int i = 0; i < sizeResume; i++) {
            storage[i] = null;
        }
        sizeResume = 0;
    }

    void save(Resume r) {
        if (r != null) {
            if (sizeResume < storage.length) {
                storage[sizeResume] = r;
                sizeResume++;
            } else {
                System.out.println("Массив резюме заполнен, очистите перед добавлением " + r);
            }

        } else {
            System.out.println("вводимое резюме " + r + " пустое...");
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < sizeResume; i++) {
            if (storage[i].toString() == uuid) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeResume; i++) {
            if (storage[i].toString() == uuid) {
                for (int j = i; j < sizeResume - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                sizeResume--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeNotNull = new Resume[sizeResume];
        System.arraycopy(storage, 0, resumeNotNull, 0, sizeResume);
        return resumeNotNull;
    }

    int size() {
        return sizeResume;
    }
}
