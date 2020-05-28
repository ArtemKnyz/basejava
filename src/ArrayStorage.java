/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeResume;

    void clear() {
        for (Resume resume : storage) {
            if (resume != null) {
                resume = null;
            }
        }
        sizeResume = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
        sizeResume++;
    }

    Resume get(String uuid) {
        Resume uuidGet = null;
        for (int i = 0; i < sizeResume; i++) {
            if (storage[i].toString() == uuid) {
                uuidGet = storage[i];
                break;
            }
        }
        return uuidGet;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeResume; i++) {
            if (storage[i].toString() == uuid) {
                for (int j = i; j < sizeResume; j++) {
                    storage[j] = storage[j + 1];
                }
                break;
            }
        }
        sizeResume--;
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
